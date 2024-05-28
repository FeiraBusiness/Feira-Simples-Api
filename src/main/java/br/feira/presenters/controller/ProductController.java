package br.feira.presenters.controller;

import java.util.List;
import java.util.UUID;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import br.feira.domain.entities.dtos.ProductDTO;
import br.feira.service.ProductService;
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

@Path("api/product")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProductController {

    @Inject
    ProductService service;

    @POST
    public ProductDTO create(ProductDTO dto) {
        return service.create(dto);
    }

    @GET
    @Path("/all")
    public List<ProductDTO> listAll() {
        return service.listAll();
    }

    @GET
    public ProductDTO findById(@HeaderParam("id") UUID id) {
        return service.findById(id);
    }

    @PUT
    public ProductDTO merge(@HeaderParam("id") UUID id, @RequestBody ProductDTO dto) {
        return service.merge(id, dto);
    }

    @DELETE
    public Response delete(@HeaderParam("id") UUID id) {
        return Response.noContent().build();
    }
}
