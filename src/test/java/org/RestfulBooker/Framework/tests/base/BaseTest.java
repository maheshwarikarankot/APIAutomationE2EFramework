package org.RestfulBooker.Framework.tests.base;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.RestfulBooker.Framework.actions.AssertionActions;
import org.RestfulBooker.Framework.endpoints.APIConstants;
import org.RestfulBooker.Framework.modules.PayloadManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.Assertion;

public class BaseTest {
    public RequestSpecification requestSpecification;
    public AssertionActions assertionActions;
    public PayloadManager payloadManager;
    public JsonPath jsonPath;
    public Response response;
    public ValidatableResponse validatableResponse;

    @BeforeMethod
    public void setUpConfig(){
        payloadManager = new PayloadManager();
        assertionActions = new AssertionActions();
        requestSpecification = (RequestSpecification) new RequestSpecBuilder()
                .setBaseUri(APIConstants.BASE_URL)
                .addHeader("Content-Type","application/json")
                .build().log().all();

    }
        public String getToken(){
            requestSpecification = RestAssured.given().baseUri(APIConstants.BASE_URL).basePath("/auth");

            String payload = "{\n" +
                    "    \"username\" : \"admin\",\n" +
                    "    \"password\" : \"password123\"\n" +
                    "}";
            response = requestSpecification.contentType(ContentType.JSON)
                    .body(payload)
                    .when().post();

            jsonPath = JsonPath.from(response.asString());
            return jsonPath.getString("token");
        }


}
