//package com.msoroka.javaee.projekt;
//
//import com.jayway.restassured.RestAssured;
//import org.junit.BeforeClass;
//import org.junit.Test;
//
//import static com.jayway.restassured.RestAssured.given;
//
//public class LicenseTest {
//
//    @BeforeClass
//    public static void setUp() {
//        RestAssured.baseURI = "http://localhost";
//        RestAssured.port = 8080;
//        RestAssured.basePath = "/projekt/api/license";
//    }
//
//    @Test
//    public void smokeTest(){
//        given().when().get("/test").then().statusCode(200);
//    }
//}
