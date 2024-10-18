package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class ThinkingTesterContactListUrl {

    protected RequestSpecification spec;

    @Before
    public void setup() {
        spec = new RequestSpecBuilder()
                .setBaseUri("https://thinking-tester-contact-list.herokuapp.com")
                .addHeader("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NzEyN2I4ZWU1ZjNjODAwMTM3MjU1ZWEiLCJpYXQiOjE3MjkyNjUzMzV9.O5eeIjkGbGWSt-VrfQAZQ9q26BOFCI9AFGyKTJVuvx4")
                .build();

    }

}
