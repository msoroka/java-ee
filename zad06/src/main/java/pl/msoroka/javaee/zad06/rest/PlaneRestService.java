package pl.msoroka.javaee.zad06.rest;

import pl.msoroka.javaee.zad06.domain.Plane;
import pl.msoroka.javaee.zad06.domain.Producer;
import pl.msoroka.javaee.zad06.service.PlaneManager;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("plane")
public class PlaneRestService {

    @Inject
    PlaneManager pm;

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addPlane(Plane plane) {
        Producer producer = new Producer("Airbus", 1920);
        plane.setProducer(producer);

        pm.addPlane(plane);

        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{planeId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updatePlane(@PathParam("planeId") int id, Plane transientPlane) {
        Plane plane = pm.getPlane(id);

        plane.setName(transientPlane.getName());
        plane.setProduceDate(transientPlane.getProduceDate());
        plane.setCapacity(transientPlane.getCapacity());
        plane.setCombustion(transientPlane.getCombustion());

        pm.updatePlane(plane);

        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    @Path("/test")
    @Produces(MediaType.TEXT_PLAIN)
    public String test(){
        return "Plane REST Service is running.";
    }

    @GET
    @Path("/{planeId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Plane getPlane(@PathParam("planeId") int id){
        return pm.getPlane(id);
    }

    @GET
    @Path("/get-all")
    @Produces(MediaType.APPLICATION_JSON)
    @SuppressWarnings("unchecked")
    public List<Plane> getAllPlanes(){
        return pm.getAllPlanes();
    }

    @DELETE
    @Path("/delete-all")
    public Response deleteAllPlanes(){
        pm.deleteAllPlanes();
        return Response.status(200).build();
    }
}
