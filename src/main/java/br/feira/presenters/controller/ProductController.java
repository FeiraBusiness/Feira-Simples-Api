package br.feira.presenters.controller;

import br.feira.domain.dtos.ProductDTO;
import br.feira.domain.entities.ProductBO;
import br.feira.service.ProductService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import java.util.List;
import java.util.UUID;

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
    @Path("all")
    public List<ProductBO> listAll() {
        return service.listAll();
    }

    @GET
    public ProductBO findById(@HeaderParam("id") UUID id) {
        return service.findById(id);
    }

    @PUT
    public ProductDTO update(@HeaderParam("id") UUID id, @RequestBody ProductDTO dto) {
        return service.update(id, dto);
    }

    @DELETE
    public ProductDTO delete(@HeaderParam("id") UUID id) {
        return service.delete(id);
    }
}
