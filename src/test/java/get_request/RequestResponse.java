package get_request;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RequestResponse {
    public static void main(String[] args) {
        String url = "https://petstore.swagger.io/v2/pet/2113";

        Response response = given().when().get(url);
        response.prettyPrint();

        //Status kod nasil yazdirilir?
        System.out.println("Status kod: " + response.getStatusCode());

        //Content Type nasil yazdirilir?
        System.out.println("Content Type: " + response.getContentType());

        //Status Line nasil yazdirilir?
        System.out.println("Status Line: " + response.getStatusLine());

        //Header bölumunden bir baslik nasil yazdirilir?
        System.out.println("Header | Server: " + response.header("Server"));

        //Header bölumunde ki tum basliklar nasil yazdirilir?
        System.out.println("Headers :\n" + response.getHeaders());

        //Time bilgisi nasil yazdirilir?
        System.out.println("Time: " + response.getTime());
    }
}
