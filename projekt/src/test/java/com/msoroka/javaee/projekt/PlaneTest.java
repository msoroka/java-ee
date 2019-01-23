package com.msoroka.javaee.projekt;

import static com.jayway.restassured.RestAssured.delete;
import static com.jayway.restassured.RestAssured.given;

import com.jayway.restassured.RestAssured;
import com.msoroka.javaee.projekt.domain.Plane;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.ws.rs.core.MediaType;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class PlaneTest {

    private static final String MODEL = "TEST123";
    private static final String SIDE_NUMBER = "TEST-123";
    private static final Date PRODUCE_DATE = new GregorianCalendar(2014,Calendar.FEBRUARY, 11).getTime();
    private static final int CAPACITY = 123;

    @BeforeClass
    public static void setUp() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
        RestAssured.basePath = "/projekt/api/plane";
    }

    @Test
    public void smokeTest(){
        given().when().get("/test").then().statusCode(200);
    }


    @Test
    public void deletePlane() {
        delete("/").then().assertThat().statusCode(200);
    }

    @Test
    public void addPlane() {
        Plane plane = new Plane(MODEL, SIDE_NUMBER, PRODUCE_DATE, CAPACITY);

        given().
                contentType(MediaType.APPLICATION_JSON).
                body(plane).
                when().
                post("/").then().assertThat().statusCode(201);


        delete("/").then().assertThat().statusCode(200);
    }

    @Test
    public void getAllPlanes() {
        given().
                contentType(MediaType.APPLICATION_JSON).
                when().
                get("/").then().assertThat().statusCode(200);

    }

    @Test
    public void getPlane() {
        given().
                contentType(MediaType.APPLICATION_JSON).
                when().
                get("/99999").then().assertThat().statusCode(204);

    }
}