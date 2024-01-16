package com.restful.booker.crudtest;

import com.restful.booker.model.BookingPojo;
import com.restful.booker.testbase.TestBase;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class PatchTest extends TestBase {
    @Test
    public void test001() {
        BookingPojo bookingPojo = new BookingPojo();
        bookingPojo.setFirstname("megha");
        bookingPojo.setLastname("vij");

        Response response = given()
                .header("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=")
                .header("Content-Type", "application/json")
                .header("Cookie", "token=1f8f6bb72e6f21c")
                .pathParam("id", 2)
                .body(bookingPojo)
                .when()
                .patch("/booking/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void test002() {

        HashMap<Object, Object> bookingdates = new HashMap<>();
        bookingdates.put("checkin", "2019-01-01");
        bookingdates.put("checkout", "2020-03-13");

        BookingPojo bookingPojo = new BookingPojo();
        bookingPojo.setFirstname("battery");
        bookingPojo.setLastname("pack");
        bookingPojo.setTotalprice(201);
        bookingPojo.setDepositpaid(true);
        bookingPojo.setBookingdates(bookingdates);
        bookingPojo.setAdditionalneeds("abcd");

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
