package br.feira.presenters.controller;

import br.feira.domain.dtos.UserDTO;
import br.feira.domain.entities.UserBO;
import br.feira.service.UserService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import java.util.List;
import java.util.UUID;

@Path("api/user")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserController {

    @Inject
    UserService service;

    @POST
    public UserDTO create(UserDTO dto) {
        return service.create(dto);
    }

    @GET
    @Path("all")
    public List<UserBO> listAll() {
        return service.listAll();
    }

    @GET
    public UserBO findById(@HeaderParam("id") UUID id) {
        return service.findById(id);
    }

    @PUT
    public UserDTO update(@HeaderParam("id") UUID id, @RequestBody UserDTO dto) {
        return service.update(id, dto);
    }

    @DELETE
    public UserDTO delete(@HeaderParam("id") UUID id) {
        return service.delete(id);
    }

}
