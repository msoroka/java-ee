package com.msoroka.javaee.projekt.rest;

import com.msoroka.javaee.projekt.service.PlaneManager;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("plane")
public class PlaneRestService {

    @EJB
    PlaneManager planeManager;

    @GET
    @Path("/test")
    @Produces(MediaType.TEXT_PLAIN)
    public String test(){
        return "Plane REST Service is running.";
    }

}
