package br.feira.presenters.controller;

import br.feira.domain.dtos.OrderDTO;
import br.feira.domain.dtos.ProductDTO;
import br.feira.domain.entities.OrderBO;
import br.feira.domain.entities.ProductBO;
import br.feira.service.OrderService;
import br.feira.service.ProductService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import java.util.List;
import java.util.UUID;

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
    @Path("all")
    public List<OrderBO> listAll() {
        return service.listAll();
    }

    @GET
    public OrderBO findById(@HeaderParam("id") UUID id) {
        return service.findById(id);
    }

    @PUT
    public OrderDTO update(@HeaderParam("id") UUID id, @RequestBody OrderDTO dto) {
        return service.update(id, dto);
    }

    @DELETE
    public OrderDTO delete(@HeaderParam("id") UUID id) {
        return service.delete(id);
    }

}
