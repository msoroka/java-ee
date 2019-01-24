package com.msoroka.javaee.projekt.rest;

import com.msoroka.javaee.projekt.service.ProducerManager;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("query")
public class QueryRestService {

    @Inject
    ProducerManager producerManager;

    @GET
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProducerPlanes(@PathParam("name") String name) {

        List<Object[]> rowProducerPlanes = producerManager.getProducerPlanes(name);
        JsonArrayBuilder producerPlanes = Json.createArrayBuilder();

        for (Object[] producerPlane: rowProducerPlanes) {
            String producerName = (String) producerPlane[0];
            String modelName = (String) producerPlane[1];

            producerPlanes.add(Json.createObjectBuilder().
                    add("producer", producerName).
                    add("model", modelName)
            );
        }

        JsonObject json = Json.createObjectBuilder().add("result", producerPlanes).build();

        return Response.ok(json, MediaType.APPLICATION_JSON).build();
    }
}
