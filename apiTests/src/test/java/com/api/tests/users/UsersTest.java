package com.api.tests.users;

import com.socks.api.conditions.Condition;
import com.socks.api.conditions.Conditions;
import com.socks.api.models.requests.NewUserRequestBody;
import com.socks.api.services.UserService;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.socks.api.conditions.Conditions.statusCode;
import static org.hamcrest.Matchers.isEmptyString;
import static org.hamcrest.Matchers.not;

public class UsersTest {

    private UserService userService = new UserService();

    @BeforeAll
    static void setUp() {
        RestAssured.baseURI = "http://35.231.186.189/";
    }

    @Test
    void testCanRegisterValidUser() {

        NewUserRequestBody user = new NewUserRequestBody()
                .setFirstName("testFirstName")
                .setLastName("TestLastName")
                .setUsername("TestUser")
                .setEmail("qqq@www.rrr")
                .setPassword("12345");

//        RestAssured.given()
//                .contentType(ContentType.JSON)
//                .log().all()
//                .body(user)
//                .when().post("register")
//                .then().log().all()
//                .assertThat()
//                .statusCode(200)
//                .body("id", not(isEmptyString()));

        userService.registerUser(user).shouldHave(statusCode(200));

    }
}
