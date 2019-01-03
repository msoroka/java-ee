package com.example.restejbjpa.rest;

import com.example.restejbjpa.domain.Dog;
import com.example.restejbjpa.domain.Person;
import com.example.restejbjpa.service.DogService;
import com.example.restejbjpa.service.PersonManager;

import javax.inject.Inject;
import javax.print.attribute.standard.Media;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("dog")
public class DogRestService {

    @Inject
    DogService dm;

    @Inject
    PersonManager pm;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addDog(Dog dog) {
//        Person person = new Person("Jan", "Kowalski", 1990);
//
//        pm.addPerson(person);
//
//        dog.setOwner(person);

        dm.addDog(dog);

//        dog.setName("TEST"); // nie zadziała
        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "It worksasdasd";
    }

}
