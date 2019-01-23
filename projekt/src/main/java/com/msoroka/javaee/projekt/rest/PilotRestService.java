package com.msoroka.javaee.projekt.rest;

import com.msoroka.javaee.projekt.domain.Pilot;
import com.msoroka.javaee.projekt.service.PilotManager;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("pilot")
public class PilotRestService {

    @EJB
    PilotManager pilotManager;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    @SuppressWarnings("unchecked")
    public List<Pilot> getAllPilots(){
        return pilotManager.getAllPilots();
    }

    @GET
    @Path("/{pilotId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Pilot getPilot(@PathParam("pilotId") int id) {
        return pilotManager.getPilot(id);
    }

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addPilot(Pilot pilot) {
        pilotManager.addPilot(pilot);

        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{pilotId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updatePilot(@PathParam("pilotId") int id, Pilot transientPilot) {
        Pilot pilot = pilotManager.getPilot(id);

        pilot.setFirstName(transientPilot.getFirstName());
        pilot.setLastName(transientPilot.getLastName());
        pilot.setBirthDate(transientPilot.getBirthDate());

        pilotManager.updatePilot(pilot);

        return Response.status(Response.Status.OK).build();
    }

    @DELETE
    @Path("/")
    public Response deleteAllPilots(){
        pilotManager.deleteAllPilots();

        return Response.status(Response.Status.OK).build();
    }

    @DELETE
    @Path("/{pilotId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deletePilot(@PathParam("pilotId") int id) {
        pilotManager.deletePilot(id);

        return Response.status(Response.Status.OK).build();
    }

    @GET
    @Path("/test")
    @Produces(MediaType.TEXT_PLAIN)
    public String test() {
        return "Pilot REST Service is running.";
    }
}
