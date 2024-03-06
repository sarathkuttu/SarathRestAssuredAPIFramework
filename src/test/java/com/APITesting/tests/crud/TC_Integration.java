package com.APITesting.tests.crud;

import com.APITesting.Base.BaseTest;
import com.APITesting.endpoints.APIConstants;
import com.APITesting.payloads.Pojos.response.BookingResponse;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.*;

public class TC_Integration extends BaseTest {
    String token;

    String bookingid;

    //Create Booking
    @Test(groups = "P0")
    public void CreateBooking() {

        token = getToken();
        System.out.println(token);

        requestSpecification.basePath(APIConstants.CREATE_UPDATE_BOOKING_URL);

        response = RestAssured.given().spec(requestSpecification)
                .when().body(payloadManager.createPayloadGSON()).post();

        validatableResponse = response.then().log().all();

        validatableResponse.statusCode(200);
        jsonPath = JsonPath.from(response.asString());
        bookingid = jsonPath.getString("bookingid");


        System.out.println("Booking ID--->" + jsonPath.getString("bookingid"));
    }

    //Update the Booking with Token and Booking ID
    @Test(groups = "P0", dependsOnMethods = {"CreateBooking"})
    public void UpdateBooking() {
        assertThat("SARATH").isEqualTo("SARATH");
        System.out.println("UpdateBooking token--->" + token);
        System.out.println("UpdateBooking Bookingid--->" + bookingid);
    }

    //DeleteBooking
    @Test(groups = "P0", dependsOnMethods = {"UpdateBooking"})
    public void DeleteBooking() {
        assertThat("SARATH").isEqualTo("SARATH");
        System.out.println("DeleteBooking token--->" + token);
        System.out.println("DeleteBooking Bookingid--->" + bookingid);
    }
}
