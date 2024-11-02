package get_request;

import baseUrl.GoRestBaseURL;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Get11 extends GoRestBaseURL {

    /*
    Given
        https://gorest.co.in/public/v1/users
    When
        User Send Get Request
    Then
        "pagination limit" : 10
    And
        "current link": "https://qorest.co.in/public/v1/users?page=1
    And
        number of users should be 10
    And
        "Kannan Ahluwalia", "The Hon. Tara Chatuverdi" and "Damayanti Dubashi" are among users
    And
        The female users are less than or equals to male users

     */


    @Test
    public void get11() {
        // Set the URL
        spec.pathParam("first", "users");

        // Set the expected data


        // Set the request and get the response
        Response response = given(spec).when().get("{first}");
        response.prettyPrint();

        // Do assertion
        response
                .then()
                .body("meta.pagination.limit", equalTo(10))
                .body("meta.pagination.links.current", equalTo("https://gorest.co.in/public/v1/users?page=1"))
                .body("data", hasSize(10))
                .body("data.status", hasItem("active"))
                .body("data.name", hasItems("Dharani Verma", "Ravi Bandopadhyay", "Acharyanandana Talwar I"));

        JsonPath json = response.jsonPath();
        List<Object> femaleList = json.getList("data.findAll{it.gender=='female'}");
        List<Object> maleList = json.getList("data.findAll{it.gender=='male'}");

        assertTrue(maleList.size() >= femaleList.size());

        // Email bilgisi ile id datasini cekme
        List<Integer> idList = json.getList("data.findAll{it.email=='dharani_verma@swift.example'}.id");
        int id = idList.getFirst();
        System.out.println(id);

    }
}
