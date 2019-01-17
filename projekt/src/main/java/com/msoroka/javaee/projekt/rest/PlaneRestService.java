package com.msoroka.javaee.projekt.rest;

import com.msoroka.javaee.projekt.domain.Plane;
import com.msoroka.javaee.projekt.service.PlaneManager;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("plane")
public class PlaneRestService {

    @EJB
    PlaneManager planeManager;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    @SuppressWarnings("unchecked")
    public List<Plane> getAllPlanes(){
        return planeManager.getAllPlanes();
    }

    @GET
    @Path("/{planeId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Plane getPlane(@PathParam("planeId") int id) {
        return planeManager.getPlane(id);
    }

    @GET
    @Path("/side-number/{sideNumber}")
    @Produces(MediaType.APPLICATION_JSON)
    public Plane getPlaneBySideNumber(@PathParam("sideNumber") String sideNumber) {
        return planeManager.getPlaneBySideNumber(sideNumber);
    }

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addPlane(Plane plane) {
        planeManager.addPlane(plane);

        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{planeId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updatePlane(@PathParam("planeId") int id, Plane transientPlane) {
        Plane plane = planeManager.getPlane(id);

        plane.setModel(transientPlane.getModel());
        plane.setSideNumber(transientPlane.getSideNumber());
        plane.setProduceDate(transientPlane.getProduceDate());
        plane.setCapacity(transientPlane.getCapacity());

        planeManager.updatePlane(plane);

        return Response.status(Response.Status.OK).build();
    }

    @DELETE
    @Path("/")
    public Response deleteAllPlanes(){
        planeManager.deleteAllPlanes();

        return Response.status(Response.Status.OK).build();
    }

    @DELETE
    @Path("/{planeId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deletePlane(@PathParam("planeId") int id) {
        planeManager.deletePlane(id);

        return Response.status(Response.Status.OK).build();
    }

    @GET
    @Path("/test")
    @Produces(MediaType.TEXT_PLAIN)
    public String test() {
        return "Plane REST Service is running.";
    }

}
