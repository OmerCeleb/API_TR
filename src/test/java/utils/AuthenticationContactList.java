package utils;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class AuthenticationContactList {


    public static String generateToken() {

        String body = "{\n" +
                "    \"email\": \"prizesurrounded@snakebutt.com\",\n" +
                "    \"password\": \"yoruldum\"\n" +
                "}";
        String url = "https://thinking-tester-contact-list.herokuapp.com/users/login";

        Response response = given().body(body).contentType(ContentType.JSON).when().post(url);

        return response.jsonPath().getString("token");


    }

}
