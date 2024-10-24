package get_request;

import baseUrl.JsonPlaceHolderBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;
import java.util.Objects;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Get08 extends JsonPlaceHolderBaseUrl {
    /*
          Given
             https://jsonplaceholder.typicode.com/todos
        When
             Kullanici URL'de bir GEt request gönderir
         Then
            1) Status code 200
            2) "Id" leri 190 dan buyuk olanlari konsola yazdir
               "Id" si 190 dan buyuk olan 10  adet veri oldugunu dogrula
            3) "Id" si 5 den kucuk olan tum kullanicilarin "userId" lerini yazdir
               "Id" si 5 den kucuk olan 4 kullanici oldugunu dogrula
            4) "Id" si 5 ten kucuk tum kullanicilarin "title" larini yazdir
                "delectus aut autem" basliginin, id numarasi 5 den kucuk bir kullaniciya ait oldugunu dogrula

     */

    @Test
    public void get08() {
        // Set the URL
        spec.pathParam("first", "todos");

        // Set the expected data

        // Send the request and get the response
        Response response = given(spec).when().get("{first}");
        // response.prettyPrint();

        // Do assertion
        assertEquals(200, response.statusCode());

        JsonPath jsonPath = response.jsonPath();
        List<Objects> idList = jsonPath.getList("findAll{it.id>190}");
        System.out.println(idList);
        assertEquals(10, idList.size());

        List<Integer> userIdList = jsonPath.getList("findAll{it.id<5}.userId");
        System.out.println(userIdList);

        List<String> userTitle = jsonPath.getList("findAll{it.id<5}.title");
        System.out.println(userTitle);

        assertTrue(userTitle.contains("delectus aut autem"));
    }
}
