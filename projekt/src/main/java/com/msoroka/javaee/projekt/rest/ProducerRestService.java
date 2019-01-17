package com.msoroka.javaee.projekt.rest;

import com.msoroka.javaee.projekt.domain.Plane;
import com.msoroka.javaee.projekt.domain.Producer;
import com.msoroka.javaee.projekt.service.ProducerManager;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("producer")
public class ProducerRestService {

    @EJB
    ProducerManager producerManager;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    @SuppressWarnings("unchecked")
    public List<Producer> getAllProducers(){
        return producerManager.getAllProducers();
    }

    @GET
    @Path("/{producerId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Producer getProducer(@PathParam("producerId") int id) {
        return producerManager.getProducer(id);
    }

    @GET
    @Path("/{producerId}/planes")
    @Produces(MediaType.APPLICATION_JSON)
    @SuppressWarnings("unchecked")
    public List<Plane> getPlanesOfProducer(@PathParam("producerId") Long id){
        return producerManager.getPlanesOfProducer(id);
    }

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addProducer(Producer producer) {
        producerManager.addProducer(producer);

        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{producerId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateProducer(@PathParam("producerId") int id, Producer transientProducer) {
        Producer producer = producerManager.getProducer(id);

        producer.setName(transientProducer.getName());
        producer.setYoe(transientProducer.getYoe());

        producerManager.updateProducer(producer);

        return Response.status(Response.Status.OK).build();
    }
    
    @DELETE
    @Path("/{producerId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteProducer(@PathParam("producerId") int id) {
        producerManager.deleteProducer(id);

        return Response.status(Response.Status.OK).build();
    }

    @GET
    @Path("/test")
    @Produces(MediaType.TEXT_PLAIN)
    public String test() {
        return "Producer REST Service is running.";
    }
}
