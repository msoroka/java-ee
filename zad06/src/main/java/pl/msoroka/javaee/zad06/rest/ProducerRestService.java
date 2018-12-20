package pl.msoroka.javaee.zad06.rest;

import pl.msoroka.javaee.zad06.domain.Producer;
import pl.msoroka.javaee.zad06.service.ProducerManager;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("producer")
public class ProducerRestService {

    @EJB
    ProducerManager pm;

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addProducer(Producer producer) {
        pm.addProducer(producer);

        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{producerId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updatePlane(@PathParam("producerId") int id, Producer transientProducer) {
        Producer producer = pm.getProducer(id);

        producer.setName(transientProducer.getName());
        producer.setYoe(transientProducer.getYoe());

        pm.updateProducer(producer);

        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    @Path("/test")
    @Produces(MediaType.TEXT_PLAIN)
    public String test(){
        return "Producer REST Service is running.";
    }

    @GET
    @Path("/{producerId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Producer getProducer(@PathParam("producerId") int id){
        return pm.getProducer(id);
    }

    @GET
    @Path("/get-all")
    @Produces(MediaType.APPLICATION_JSON)
    @SuppressWarnings("unchecked")
    public List<Producer> getAllProducers(){
        return pm.getAllProducers();
    }

    @DELETE
    @Path("/delete-all")
    public Response deleteAllProducers(){
        pm.deleteAllProducers();
        return Response.status(200).build();
    }


}
