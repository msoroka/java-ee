package com.example.restservicedemo.service;


import com.example.restservicedemo.domain.Dog;
import com.sun.jersey.spi.resource.Singleton;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Path("/dog")
@Singleton
public class DogRestService {

    Map<Long, Dog> db = new HashMap<>();

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Dog getDog(@PathParam(value = "id") long id) {
        return db.get(id);
    }

    @POST
    @Consumes("application/json")
    public Response addDog(Dog dog){
        long newKey = db.keySet().size() + 1;

        db.put(newKey, dog);

        return Response.ok().build();
    }

}
