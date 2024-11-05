package test_data;

import java.util.HashMap;
import java.util.Map;

public class HerokuAppTestData {

    public Map<String, String> getBookingDates(String checkIn, String checkout) {
        Map<String, String> bookingsDatesData = new HashMap<>();
        if (checkIn != null) {
            bookingsDatesData.put("checkIn", checkIn);
        }
        if (checkout != null) {
            bookingsDatesData.put("checkout", checkout);
        }


        return bookingsDatesData;


    }

    public Map<String, Object> getPayload(String firstname, String lastname, Integer totalprice, Boolean depositpaid, Map<String, String> bookingdates, String additionalneeds) {
        Map<String, Object> expactedData = new HashMap<>();
        if (firstname != null) {
            expactedData.put("firstname", firstname);
        }
        if (lastname != null) {
            expactedData.put("lastname", lastname);
        }
        if (totalprice != null) {
            expactedData.put("totalprice", totalprice);
        }
        if (depositpaid != null) {
            expactedData.put("depositpaid", depositpaid);
        }
        if (bookingdates != null) {
            expactedData.put("bookingdates", bookingdates);
        }
        if (additionalneeds != null) {
            expactedData.put("additionalneeds", additionalneeds);
        }


        return expactedData;
    }


}

