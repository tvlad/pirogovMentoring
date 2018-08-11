package com.socks.api.services;

import com.socks.api.AssertableResponse;
import com.socks.api.models.requests.NewUserRequestBody;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static org.hamcrest.Matchers.not;

public class UserService {

    private RequestSpecification setUp() {
        return RestAssured
                .given()
                .contentType(ContentType.JSON)
                .filters(new RequestLoggingFilter(),
                        new ResponseLoggingFilter())
                ;
    }

    public AssertableResponse registerUser(NewUserRequestBody user) {

        Response response = setUp()
                .body(user)
                .when().post("register")
                .then().extract().response();

        return new AssertableResponse(response);
    }

}
