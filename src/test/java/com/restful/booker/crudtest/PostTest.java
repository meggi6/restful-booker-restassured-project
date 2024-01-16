package com.restful.booker.crudtest;

import com.restful.booker.model.BookingPojo;
import com.restful.booker.testbase.TestBase;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class PostTest extends TestBase {
    @Test
    public void test001() {

        BookingPojo bookingPojo = new BookingPojo();
        bookingPojo.setUsername("admin");
        bookingPojo.setPassword("password123");

        Response response = given()
                .body(bookingPojo)
                .when()
                .post("/auth");
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void test002() {

        HashMap<Object, Object> bookingdates = new HashMap<>();
        bookingdates.put("checkin", "2022-03-01");
        bookingdates.put("checkout", "2021-05-11");

        BookingPojo bookingPojo = new BookingPojo();
        bookingPojo.setFirstname("battery");
        bookingPojo.setLastname("pack");
        bookingPojo.setTotalprice(201);
        bookingPojo.setDepositpaid(true);
        bookingPojo.setBookingdates(bookingdates);
        bookingPojo.setAdditionalneeds("abcds");

        Response response = given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer b5f2ee3fca5b4efacce265745546d4fd7f1501611b151cf408ac45f7648bb5d0")
                .body(bookingPojo)
                .when()
                .post("/booking");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}
