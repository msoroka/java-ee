package com.msoroka.javaee.projekt.rest;

import com.msoroka.javaee.projekt.domain.License;
import com.msoroka.javaee.projekt.service.LicenseManager;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("license")
public class LicenseRestService {

    @EJB
    LicenseManager licenseManager;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    @SuppressWarnings("unchecked")
    public List<License> getAllLicenses(){
        return licenseManager.getAllLicenses();
    }

    @GET
    @Path("/{licenseId}")
    @Produces(MediaType.APPLICATION_JSON)
    public License getLicense(@PathParam("licenseId") int id) {
        return licenseManager.getLicense(id);
    }

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addLicense(License license) {
        licenseManager.addLicense(license);

        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{licenseId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateLicense(@PathParam("licenseId") int id, License transientLicense) {
        License license = licenseManager.getLicense(id);

        license.setNumber(transientLicense.getNumber());
        license.setGrantingDate(transientLicense.getGrantingDate());

        licenseManager.updateLicense(license);

        return Response.status(Response.Status.OK).build();
    }

    @DELETE
    @Path("/")
    public Response deleteAllLicenses(){
        licenseManager.deleteAllLicenses();

        return Response.status(Response.Status.OK).build();
    }

    @DELETE
    @Path("/{licenseId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteLicense(@PathParam("licenseId") int id) {
        licenseManager.deleteLicense(id);

        return Response.status(Response.Status.OK).build();
    }

    @GET
    @Path("/test")
    @Produces(MediaType.TEXT_PLAIN)
    public String test() {
        return "License REST Service is running.";
    }
}
