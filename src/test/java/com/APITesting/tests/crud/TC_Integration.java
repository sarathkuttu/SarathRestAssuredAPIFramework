package com.APITesting.tests.crud;

import com.APITesting.Base.BaseTest;
import com.APITesting.endpoints.APIConstants;
import com.APITesting.modules.PayloadManager;
import com.APITesting.payloads.Pojos.request.Booking;
import com.APITesting.payloads.Pojos.response.BookingResponse;
import io.qameta.allure.internal.shadowed.jackson.core.JsonProcessingException;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ValidatableResponse;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static com.APITesting.modules.PayloadManager.*;
import static org.assertj.core.api.Assertions.*;

public class TC_Integration extends BaseTest {
    String token;

    String bookingid;
    String bookingIdPojo;


    //Create Booking
    @Test(groups = "P0")
    public void CreateBooking() throws JsonProcessingException {

        token = getToken();
        System.out.println(token);

        assertThat(token).isNotNull().isNotEmpty();

        requestSpecification.basePath(APIConstants.CREATE_UPDATE_BOOKING_URL);

        response = RestAssured.given().spec(requestSpecification)
                .when().body(payloadManager.createPayloadGSON()).post();

        validatableResponse = response.then().log().all();

        validatableResponse.statusCode(200);
        jsonPath = JsonPath.from(response.asString());

        //Direct Extraction from json path
        bookingid = jsonPath.getString("bookingid");

       //Booking Response Class
        BookingResponse bookingResponse  = payloadManager.JsonToObject(response.asString());
        bookingIdPojo = bookingResponse.getBookingid().toString();

        System.out.println("Booking ID--->" + jsonPath.getString("bookingid"));
        System.out.println("JSON BOOKING ID-->" +bookingid);
        System.out.println("bookingIdPojo-->" +bookingIdPojo);

        assertThat(bookingid).isNotNull().isNotEmpty();
    }

    //Update the Booking with Token and Booking ID
    @Test(groups = "P0", dependsOnMethods = {"CreateBooking"})
    public void UpdateBooking() throws JsonProcessingException {
        assertThat("SARATH").isEqualTo("SARATH");
        System.out.println("UpdateBooking token--->" + token);
        System.out.println("UpdateBooking Bookingid--->" + bookingid);
        requestSpecification.basePath(APIConstants.CREATE_UPDATE_BOOKING_URL+"/"+bookingid);

        response = RestAssured.given().spec(requestSpecification)
                .cookie("token",token)
                .when().body(payloadManager.UpdatePayload()).put();

        validatableResponse = response.then().log().all();
       // validatableResponse.body("firstname", Matchers.is("SARATH"));

        Booking bookingResponse = payloadManager.JsonToObjectPUT(response.asString());
        assertThat(bookingResponse.getFirstname()).isEqualTo("SARATH");
        assertThat(bookingResponse.getLastname()).isEqualTo("T V");
    }

    //DeleteBooking
    @Test(groups = "P0", dependsOnMethods = {"UpdateBooking"})
    public void DeleteBooking() {

        System.out.println("DeleteBooking token--->" + token);
        System.out.println("DeleteBooking Bookingid--->" + bookingid);
    }
}
