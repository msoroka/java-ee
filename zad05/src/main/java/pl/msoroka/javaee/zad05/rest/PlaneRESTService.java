package pl.msoroka.javaee.zad05.rest;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import pl.msoroka.javaee.zad05.domain.Plane;
import pl.msoroka.javaee.zad05.service.PlaneManager;

@Path("plane")
@Stateless
public class PlaneRESTService {

    @Inject
    private PlaneManager pm;

    @GET
    @Path("/{planeId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Plane getPlane(@PathParam("planeId") Integer id) {
        Plane p = pm.getPlane(id);
        return p;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Plane> getPlanes() {
        return pm.getAllPlanes();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addPlane(Plane plane) {
        pm.addPlane(plane);

        return Response.status(201).entity("Plane successfully created.").build();
    }

    @GET
    @Path("/test")
    @Produces(MediaType.TEXT_PLAIN)
    public String test() {
        return "This is working PlaneRESTService";
    }

    @DELETE
    public Response clearPlanes() {
        pm.deleteAllPlanes();
        return Response.status(200).entity("All planes successfully deleted.").build();
    }

}
