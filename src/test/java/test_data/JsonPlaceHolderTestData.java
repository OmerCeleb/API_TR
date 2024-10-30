package test_data;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class JsonPlaceHolderTestData {

    public Map<String, Object> getPayLoad(Integer userId, String title, Boolean completed) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("userId", userId);
        payload.put("title", title);
        payload.put("completed", completed);

        return payload;

    }

}



