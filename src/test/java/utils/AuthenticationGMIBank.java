package utils;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class AuthenticationGMIBank {


    public static String generateTokenBANK() {

        String body = "{\n" +
                "  \"password\": \"Mark123\",\n" +
                "  \"rememberMe\": true,\n" +
                "  \"username\": \"mark_twain\"\n" +
                "}";
        String url = "https://gmibank.com/api/authenticate";

        Response response = given().body(body).contentType(ContentType.JSON).when().post(url);

        return response.jsonPath().getString("id_token");


    }

}
