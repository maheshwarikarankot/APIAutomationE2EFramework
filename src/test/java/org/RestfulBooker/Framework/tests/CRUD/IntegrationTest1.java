package org.RestfulBooker.Framework.tests.CRUD;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.RestfulBooker.Framework.endpoints.APIConstants;
import org.RestfulBooker.Framework.modules.PayloadManager;
import org.RestfulBooker.Framework.tests.base.BaseTest;
import org.hamcrest.Matchers;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class IntegrationTest1 extends BaseTest {
    String token;
    @Test(groups = "Integration")
    @Owner("Maheshwari K")
    @Description("Verify that the booking can be created")
    public void testCreateBooking(ITestContext iTestContext){
        requestSpecification.basePath(APIConstants.CREATE_BOOKING);
        response = RestAssured.given().spec(requestSpecification)
                .when().body(payloadManager.createPayload()).post();
        validatableResponse = response.then().log().all();

        jsonPath = JsonPath.from(response.asString());
        System.out.println("Booking ID : "+jsonPath.getString("bookingid"));

        validatableResponse.statusCode(200);
        iTestContext.setAttribute("bookingid",jsonPath.getString("bookingid"));

    }

    @Test(groups = "Integration", dependsOnMethods = "testCreateBooking")
    public void testUpdateCreatedBooking(ITestContext iTestContext){
        token = getToken();

        String bookingId = (String) iTestContext.getAttribute("bookingid");
        System.out.println("Maheshwari K - " + bookingId);
        requestSpecification.basePath(APIConstants.UPDATE_BOOKING + bookingId);
        response = RestAssured.given().spec(requestSpecification).cookie("token",token)
                .when().body(payloadManager.updatePayload()).put();
        validatableResponse = response.then().log().all();
        validatableResponse.body("firstname", Matchers.is("Mahi"));

    }

    @Test(groups = "Integration",dependsOnMethods = "testUpdateCreatedBooking")
    public void testDeleteCreatedBooking(ITestContext iTestContext) {

        requestSpecification.basePath(APIConstants.UPDATE_BOOKING  + (String) iTestContext.getAttribute("bookingid")).cookie("token",token);
        validatableResponse = RestAssured.given().spec(requestSpecification).auth().basic("admin", "password123")
                .when().delete().then().log().all();
        validatableResponse.statusCode(201);
    }

}


