package com.herokuapp.booker.restful.booking;

import com.herokuapp.booker.restful.testbase.TestBase;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetBooking extends TestBase {

    @Test
    public void verifyBooking(){
        Response response = given()
                .when()
                .get("/booking");
        response.prettyPrint();
        response.then().statusCode(200);
    }

    @Test
    public void verifyBookingIdS(){
        Response response = given()
                .when()
                .get("/booking/15");
        response.prettyPrint();
        response.then().statusCode(200);
    }
}
