package com.msoroka.javaee.projekt;

import com.jayway.restassured.RestAssured;
import com.msoroka.javaee.projekt.domain.License;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.ws.rs.core.MediaType;
import java.util.*;

import static com.jayway.restassured.RestAssured.delete;
import static com.jayway.restassured.RestAssured.given;


public class LicenseTest {

    private static final String NUMBER = "AJ123";
    private static final Date GRANTING_DATE = new GregorianCalendar(2014, Calendar.FEBRUARY, 11).getTime();

    @BeforeClass
    public static void setUp() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
        RestAssured.basePath = "/projekt/api/license";
    }

    @Test
    public void smokeTest() {
        given().when().get("/test").then().statusCode(200);
    }

    @Test
    public void deleteLicense() {
        delete("/").then().assertThat().statusCode(200);
    }

    @Test
    public void addLicense() {
        License license = new License(NUMBER, GRANTING_DATE);

        given().
                contentType(MediaType.APPLICATION_JSON).
                body(license).
                when().
                post("/").then().assertThat().statusCode(201);


        delete("/").then().assertThat().statusCode(200);
    }


    @Test
    public void getAllLicenses() {
        given().
                contentType(MediaType.APPLICATION_JSON).
                when().
                get("/").then().assertThat().statusCode(200);

    }


    @Test
    public void getLicense() {
        given().
                contentType(MediaType.APPLICATION_JSON).
                when().
                get("/0").then().assertThat().statusCode(204);

    }
}
