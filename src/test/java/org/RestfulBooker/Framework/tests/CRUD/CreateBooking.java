package org.RestfulBooker.Framework.tests.CRUD;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.RestfulBooker.Framework.endpoints.APIConstants;
import org.RestfulBooker.Framework.tests.base.BaseTest;
import org.testng.annotations.Test;

public class CreateBooking extends BaseTest {
    @Test(groups = "smoke")
    @Owner("Maheshwari K")
    @Description("Verify that create bookingResponse is working fine with status code 200")
    public void testCreateBooking(){

        requestSpecification.basePath(APIConstants.CREATE_BOOKING);
        response = RestAssured.given().spec(requestSpecification)
                .when().body(payloadManager.createPayload()).post();
        validatableResponse = response.then().log().all();
        jsonPath = JsonPath.from(response.asString());
        System.out.println("BookingID :" + jsonPath.getString("bookingid"));
        assertionActions.verifyStatusCode(response);
    }
}
