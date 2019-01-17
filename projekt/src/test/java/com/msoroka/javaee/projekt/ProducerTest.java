package com.msoroka.javaee.projekt;

import static com.jayway.restassured.RestAssured.given;

import com.jayway.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;

public class ProducerTest {

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
}