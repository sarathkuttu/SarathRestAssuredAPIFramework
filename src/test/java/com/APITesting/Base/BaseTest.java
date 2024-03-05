package com.APITesting.Base;

import com.APITesting.actions.AssertActions;
import com.APITesting.endpoints.APIConstants;
import com.APITesting.modules.PayloadManager;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    public RequestSpecification requestSpecification;
    public AssertActions assertActions;
    public PayloadManager payloadManager;
    public JsonPath jsonPath;
    public Response response;
    public ValidatableResponse validatableResponse;


    @BeforeMethod

    public void SetConfig(){
        payloadManager = new PayloadManager();
        assertActions = new AssertActions();
        //requestSpecification = RestAssured.given();

        requestSpecification = new RequestSpecBuilder()

                .setBaseUri(APIConstants.BASE_URL)
                .addHeader("Content-Type","application/json")
                .build().log().all();






    }




}
