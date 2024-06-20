    package br.feira.presenters.controller;

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
        public Response create(ProductDTO dto) {
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

        @PUT
        public Response merge(@HeaderParam("id") UUID id, @RequestBody ProductDTO dto) {
            var update = service.merge(id, dto);

            return Response.ok(update).build();
        }

        @DELETE
        public Response delete(@HeaderParam("id") UUID id) {
            return Response.noContent().build();
        }
    }
