package pl.msoroka.javaee.zad06.rest;

import pl.msoroka.javaee.zad06.domain.Plane;
import pl.msoroka.javaee.zad06.domain.Producer;
import pl.msoroka.javaee.zad06.service.ProducerManager;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("producer")
public class ProducerRestService {

    @EJB
    ProducerManager pm;

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addProducer(Producer producer) {
        Plane plane1 = new Plane("A330", "2018-01-05", 125, 25.5);
        Plane plane2 = new Plane("A333", "2017-02-04", 155, 35.5);
        Plane plane3 = new Plane("A350", "2016-03-03", 175, 45.5);
        Plane plane4 = new Plane("A370", "2015-04-02", 250, 55.5);

        List<Plane> planes = new ArrayList<>();
        planes.add(plane1);
        planes.add(plane2);
        planes.add(plane3);
        planes.add(plane4);

        producer.setPlanes(planes);
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
