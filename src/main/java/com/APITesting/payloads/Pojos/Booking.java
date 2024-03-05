package com.APITesting.payloads.Pojos;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.*;

public class Booking {

    RequestSpecification requestSpecification;

    ValidatableResponse validatableResponse;

    @Test
    public void CreateBookingTC1() {

//PayloAD


        CreateBookingSimple Booking = new CreateBookingSimple();
        Booking.setFirstname("Keerthana");

        Booking.setLastname("Aravind");

        Booking.setTotalprice(7000);

        Booking.setDepositpaid(true);

        Bookingdates bookingdate = new Bookingdates();
        bookingdate.setCheckin("2024-03-19");
        bookingdate.setCheckout("2024-03-27");

        Booking.setBookingdates(bookingdate);

        Booking.setAdditionalneeds("Breakfast");

        System.out.println(Booking);

        //Object--->JSON

        Gson gson = new Gson();

        String jsonStringBooking = gson.toJson(Booking);


        System.out.println(jsonStringBooking);

        requestSpecification = RestAssured.given();

        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(jsonStringBooking).log().all();

        Response response = requestSpecification.when().post();

        //JSON---->Object
        String jsonResponseString = response.asString();

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        BookingResponse bookingresponseObject = gson.fromJson(jsonResponseString, BookingResponse.class);

        String expectedFirstName = "Keerthana"; // Replace with the expected first name
        String expectedLastName = "Aravind"; // Replace with the expected last name


        Assert.assertEquals(expectedFirstName, bookingresponseObject.getBooking().getFirstname());
        Assert.assertEquals(expectedLastName, bookingresponseObject.getBooking().getLastname());


        assertThat(bookingresponseObject.getBookingid()).isNotNull();
        assertThat(bookingresponseObject.getBooking().getFirstname()).isNotNull();
        assertThat(bookingresponseObject.getBooking().getFirstname()).isEqualTo("Keerthana");

    }


}
