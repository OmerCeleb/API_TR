package baseUrl;

import io.restassured.builder.RequestSpecBuilder;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

import static utils.AuthenticationContactList.generateToken;
import static utils.AuthenticationHorekuApp.generateTokenH;

public class HerokuAppBaseUrl {

    protected RequestSpecification spec;

    @Before
    public void setup() {
        spec = new RequestSpecBuilder()
                .setBaseUri("https://restful-booker.herokuapp.com")
                .setContentType(ContentType.JSON)
                .addHeader("Cookie", "token=" + generateTokenH())
                .build();
    }


}
