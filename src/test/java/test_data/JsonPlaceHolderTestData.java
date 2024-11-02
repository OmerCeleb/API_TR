package test_data;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class JsonPlaceHolderTestData {

    public Map<String, Object> getPayLoad(Integer userId, String title, Boolean completed) {
        Map<String, Object> payload = new HashMap<>();
        if (userId != null) {
            payload.put("userId", userId);
        }
        if (title != null) {
            payload.put("title", title);
        }
        if (completed != null) {
            payload.put("completed", completed);
        }


        return payload;

    }

}



