package com.restful.booker.crudtest;

import com.restful.booker.testbase.TestBase;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeleteTest extends TestBase {
    @Test
    public void test001() {
        Response response = given()
                .header("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=")
                .header("Content-Type", "application/json")
                .pathParam("id", 648)
                .when()
                .delete("/booking/{id}");
        response.then().statusCode(125);
        response.prettyPrint();
    }
}
