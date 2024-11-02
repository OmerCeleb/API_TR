package test_data;

import java.util.HashMap;
import java.util.Map;

public class HerokuAppTestData {

    public Map<String, String> getBookingDates(String checkIn, String checkout) {
        Map<String, String> bookingsDatesData = new HashMap<>();
        bookingsDatesData.put("checkIn", checkIn);
        bookingsDatesData.put("checkout", checkout);

        return bookingsDatesData;


    }

    public Map<String, Object> getPayload(String firstname, String lastname, Integer totalprice, Boolean depositpaid, Map<String, String> bookingdates, String additionalneeds) {
        Map<String, Object> expactedData = new HashMap<>();
        expactedData.put("firstname", firstname);
        expactedData.put("lastname", lastname);
        expactedData.put("totalprice", totalprice);
        expactedData.put("depositpaid", depositpaid);
        expactedData.put("bookingdates", bookingdates);
        expactedData.put("additionalneeds", additionalneeds);

        return expactedData;
    }


}

