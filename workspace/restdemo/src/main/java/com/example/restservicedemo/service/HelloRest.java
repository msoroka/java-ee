package com.example.restservicedemo.service;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/hello")
public class HelloRest {

    @GET
    @Path("/test/")
    @Produces("text/html")
    public String test() {
        return "REST Service is running";
    }

//    @POST

}
