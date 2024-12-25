package com.herokuapp.booker.restful.booking;

import com.herokuapp.booker.restful.model.BookingPojo;
import com.herokuapp.booker.restful.testbase.TestBase;
import com.herokuapp.booker.restful.utils.TestUtils;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class CreateBooking extends TestBase {

    static String id;

    @Test
    public void createBookingSuccessfully(){

        String firstName = TestUtils.getRandomValue() + "Prashant";
        String lastName = TestUtils.getRandomValue() + "p";
        int totalPrice = 123;
        boolean depositPaid = true;
        HashMap<String, String> bookingDates = new HashMap<>();
        String checkIn = "2025-01-12";
        String checkOut = "2025-01-15";
        bookingDates.put("checkin", checkIn);
        bookingDates.put("checkout", checkOut);
        String additionalNeeds = "extra Towels";

        BookingPojo bookingPojo = new BookingPojo();
        bookingPojo.setFirstname(firstName);
        bookingPojo.setLastname(lastName);
        bookingPojo.setTotalprice(totalPrice);
        bookingPojo.setDepositpaid(depositPaid);
        bookingPojo.setBookingdates(bookingDates);
        bookingPojo.setAdditionalneeds(additionalNeeds);

        Response response = given().log().all()
                .header("Content-Type", "application/json")
                .when()
                .body(bookingPojo)
                .post("/booking");
        response.prettyPrint();
        response.then().statusCode(200);

        id = response.jsonPath().getString("bookingid");
        response.prettyPrint();
        response.then().statusCode(200);
    }
}
