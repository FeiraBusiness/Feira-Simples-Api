package br.feira.presenters.controller;

import br.feira.domain.entities.dtos.CompanyDTO;
import br.feira.domain.entities.dtos.UserDTO;
import br.feira.service.CompanyService;
import br.feira.service.PaymentService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import java.util.UUID;

@Path("api/company")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CompanyController {

    @Inject
    CompanyService service;

    @POST
    public Response create(CompanyDTO dto) {
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
    public Response update(@HeaderParam("id") UUID id, @RequestBody CompanyDTO dto) {
        var update = service.merge(id, dto);

        return Response.ok(update).build();
    }

    @DELETE
    public Response delete(@HeaderParam("id") UUID id) {
        return Response.noContent().build();
    }

}