package br.feira.presenters.controller;

import java.util.List;
import java.util.UUID;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import br.feira.domain.entities.dtos.UserDTO;
import br.feira.service.UserService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

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
    @Path("/all")
    public List<UserDTO> listAll() {
        return service.listAll();
    }

    @GET
    public UserDTO findById(@HeaderParam("id") UUID id) {
        return service.findById(id);
    }

    @PATCH
    public UserDTO update(@HeaderParam("id") UUID id, @RequestBody UserDTO dto) {
        return service.merge(id, dto);
    }

    @DELETE
    public Response delete(@HeaderParam("id") UUID id) {
        return Response.noContent().build();
    }

}
