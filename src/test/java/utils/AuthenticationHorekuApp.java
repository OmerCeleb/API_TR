package utils;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class AuthenticationHorekuApp {


    public static String generateToken() {

        String body = "{\n" +
                "    \"username\": \"admin\",\n" +
                "    \"password\": \"password123\"\n" +
                "}";
        String url = "https://restfull-booker.horekuapp.com/auth";

        Response response = given().body(body).contentType(ContentType.JSON).when().post(url);

        return response.jsonPath().getString("token");


    }

}
