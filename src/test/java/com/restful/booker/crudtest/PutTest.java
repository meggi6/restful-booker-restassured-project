package com.restful.booker.crudtest;

import com.restful.booker.model.BookingPojo;
import com.restful.booker.testbase.TestBase;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class PutTest extends TestBase {
    @Test
    public void test001() {

        HashMap<Object, Object> bookingdates = new HashMap<>();
        bookingdates.put("checkin", "2020-01-01");
        bookingdates.put("checkout", "2022-01-01");

        BookingPojo bookingPojo = new BookingPojo();
        bookingPojo.setFirstname("shinchan");
        bookingPojo.setLastname("mrbean");
        bookingPojo.setTotalprice(1000);
        bookingPojo.setDepositpaid(false);
        bookingPojo.setBookingdates(bookingdates);
        bookingPojo.setAdditionalneeds("abcd");

        Response response = given()
                .header("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=")
                .header("Content-Type", "application/json")
                .header("Cookie", "token=1f8f6bb72e6f21c")
                .pathParam("id", 125)
                .body(bookingPojo)
                .when()
                .put("/booking/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}
