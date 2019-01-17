package com.example.restejbjpa.rest;

import com.example.restejbjpa.domain.Beer;
import com.example.restejbjpa.service.BeerManager;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("beer")
public class BeerRestService {

    @Inject
    BeerManager beerManager;

    @GET
    @Path("/add")
    @Produces(MediaType.APPLICATION_JSON)
    public Response add(){

        beerManager.add();

        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    @Path("/{yop}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Beer> getOldBeer(@PathParam("yop") int yop) {
        return beerManager.getOldBeer(yop);
    }

    @GET
    @Path("/test")
    @Produces(MediaType.TEXT_PLAIN)
    public String test() {
        return "Beer REST Service is working";
    }
}
