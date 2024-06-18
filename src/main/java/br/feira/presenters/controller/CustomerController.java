package br.feira.presenters.controller;

import java.util.UUID;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import br.feira.domain.entities.dtos.CustomerDTO;
import br.feira.service.CustomerService;
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
public class CustomerController {

    @Inject
    CustomerService service;

    @POST
    public Response create(CustomerDTO dto) {
        var create = service.create(dto);

        return Response.ok(create).build();
    }

    @GET
    @Path("/all")
    public Response listAll() {
        var list = service.listAll();

        return Response.ok(list).build();
    }

    @GET
    public Response findById(@HeaderParam("id") UUID id) {
        var findBy = service.findById(id);

        return Response.ok(findBy).build();
    }

    @PATCH
    public Response update(@HeaderParam("id") UUID id, @RequestBody CustomerDTO dto) {
        var update = service.merge(id, dto);
        
        return Response.ok(update).build();
    }

    @DELETE
    public Response delete(@HeaderParam("id") UUID id) {
        return Response.noContent().build();
    }

}
