package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

import static utils.AuthenticationGMIBank.generateTokenBANK;

public class GMIBankBaseUrl {

    protected RequestSpecification spec;

    @Before
    public void setup() {
        spec = new RequestSpecBuilder()
                .setBaseUri("https://gmibank.com")
                .setContentType(ContentType.JSON)
                .addHeader("Authorization", "Bearer " + generateTokenBANK())
                .build();

    }

}
