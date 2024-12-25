package com.herokuapp.booker.restful.booking;

import com.herokuapp.booker.restful.testbase.TestBase;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeleteUser extends TestBase {

    @Test
    public void verifyBookingDeleteSuccessfully() {

        given().log().all()
                .pathParam("id",1)
                .when()
                .delete("/{id}")
                .then()
                .statusCode(404);
    }
}
