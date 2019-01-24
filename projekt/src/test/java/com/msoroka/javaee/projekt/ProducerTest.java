package com.msoroka.javaee.projekt;

import static com.jayway.restassured.RestAssured.given;

import com.jayway.restassured.RestAssured;
import com.msoroka.javaee.projekt.domain.Producer;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.ws.rs.core.MediaType;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class ProducerTest {

    private static final String NAME = "TEST";
    private static final Date YOE = new GregorianCalendar(2014, Calendar.FEBRUARY, 11).getTime();

    @BeforeClass
    public static void setUp() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
        RestAssured.basePath = "/projekt/api/producer";
    }

    @Test
    public void smokeTest(){
        given().when().get("/test").then().statusCode(200);
    }

    @Test
    public void getAllProducers() {
        given().
                contentType(MediaType.APPLICATION_JSON).
                when().
                get("/").then().assertThat().statusCode(200);

    }

    @Test
    public void getProducer() {
        given().
                contentType(MediaType.APPLICATION_JSON).
                when().
                get("/0").then().assertThat().statusCode(204);

    }
}