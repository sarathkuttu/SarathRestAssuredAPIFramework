package com.APITesting.tests.crud;

import com.APITesting.Base.BaseTest;
import com.APITesting.endpoints.APIConstants;
import com.APITesting.modules.PayloadManager;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

public class TCCreateBooking extends BaseTest {


    @Owner("SARATH")

    @Description("Verify that create booking is working with valid Payload and Status code 200")
    @Test

    public void PositiveTC1() {

        requestSpecification.basePath(APIConstants.CREATE_UPDATE_BOOKING_URL);

        response = RestAssured.given().spec(requestSpecification)
                .when().body(payloadManager.createPayloadGSON()).post();

        validatableResponse = response.then().log().all();

        validatableResponse.statusCode(200);

        jsonPath = JsonPath.from(response.asString());
    }
}
