package br.feira.presenters.controller;

import java.util.List;
import java.util.UUID;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import br.feira.domain.dtos.OrderDTO;
import br.feira.domain.entities.OrderBO;
import br.feira.service.OrderService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("api/order")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class OrderController {

    @Inject
    OrderService service;

    @POST
    public OrderDTO create(OrderDTO dto) {
        return service.create(dto);
    }

    @GET
    @Path("/all")
    public List<OrderDTO> listAll() {
        return service.listAll();
    }

    @GET
    public OrderDTO findById(@HeaderParam("id") UUID id) {
        return service.findById(id);
    }

    @PUT
    public OrderDTO update(@HeaderParam("id") UUID id, @RequestBody OrderDTO dto) {
        return service.update(id, dto);
    }

    @DELETE
    public Response delete(@HeaderParam("id") UUID id) {
        return Response.noContent().build();
    }

}
