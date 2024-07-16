package br.feira.domain.usecases.auth;

import br.feira.infra.database.postgres.model.PgSeller;
import br.feira.infra.database.postgres.model.User;
import io.smallrye.jwt.build.Jwt;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import javax.naming.AuthenticationException;
import java.util.Arrays;
import java.util.HashSet;

@ApplicationScoped
public class AuthService {

    @Inject
    UserRepository userRepository;

    @Transactional
    public AuthenticationResponse authenticate(AuthenticationRequest request) throws AuthenticationException {
        User user = userRepository.find("username", request.username()).firstResult();
        if (user == null || !user.getPassword().equals(request.password())) {
            throw new AuthenticationException("Invalid username or password");
        }

        String token = Jwt.issuer("feirafacil")
                .upn(request.username())
                .groups(new HashSet<>(Arrays.asList("User")))
                .sign();

        return new AuthenticationResponse(token);
    }

    @Transactional
    public void register(RegisterRequest request) {
        User user = new User();
        user.setUsername(request.username());
        user.setPassword(request.password());
        user.setEmail(request.email());
        userRepository.persist(user);
    }
}
