package com.msoroka.javaee.projekt;

import com.jayway.restassured.RestAssured;
import com.msoroka.javaee.projekt.domain.Pilot;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.ws.rs.core.MediaType;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static com.jayway.restassured.RestAssured.delete;
import static com.jayway.restassured.RestAssured.given;

public class PilotTest {

    private static final String FIRST_NAME = "Jan";
    private static final String LAST_NAME = "Testowy";
    private static final Date BIRTH_DATE = new GregorianCalendar(2014, Calendar.FEBRUARY, 11).getTime();

    @BeforeClass
    public static void setUp() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
        RestAssured.basePath = "/projekt/api/pilot";
    }

    @Test
    public void smokeTest(){
        given().when().get("/test").then().statusCode(200);
    }

    @Test
    public void deletePilot() {
        delete("/").then().assertThat().statusCode(200);
    }

    @Test
    public void addPilot() {
        Pilot pilot = new Pilot(FIRST_NAME, LAST_NAME, BIRTH_DATE);

        given().
                contentType(MediaType.APPLICATION_JSON).
                body(pilot).
                when().
                post("/").then().assertThat().statusCode(201);


        delete("/").then().assertThat().statusCode(200);
    }

    @Test
    public void getAllPilots() {
        given().
                contentType(MediaType.APPLICATION_JSON).
                when().
                get("/").then().assertThat().statusCode(200);

    }


    @Test
    public void getPilot() {
        given().
                contentType(MediaType.APPLICATION_JSON).
                when().
                get("/99999").then().assertThat().statusCode(204);

    }
}
