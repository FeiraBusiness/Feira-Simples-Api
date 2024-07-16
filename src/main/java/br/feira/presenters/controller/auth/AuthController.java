package br.feira.presenters.controller.auth;

import br.feira.domain.usecases.auth.AuthService;
import br.feira.domain.usecases.auth.AuthenticationRequest;
import br.feira.domain.usecases.auth.AuthenticationResponse;
import br.feira.domain.usecases.auth.RegisterRequest;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import javax.naming.AuthenticationException;

@Path("api/auth")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AuthController {

    @Inject
    AuthService authService;

    @POST
    @Path("/register")
    public Response register(@Valid @RequestBody RegisterRequest request) {
        authService.register(request);
        return Response.status(Response.Status.CREATED).build();
    }

    @POST
    @Path("/authenticate")
    public Response authenticate(@Valid @RequestBody AuthenticationRequest request) throws AuthenticationException {
        AuthenticationResponse response = authService.authenticate(request);
        return Response.status(Response.Status.OK).entity(response).build();
    }
}

