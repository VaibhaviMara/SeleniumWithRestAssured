package basic.map;

import java.util.HashMap;
import java.util.Map;

public class MapStore {

    static Map<String, Object> mapResponse = new HashMap<>();
    public static Map<String, Object> createUserRequest() {
        mapResponse.put("id", "1");
        mapResponse.put("username", "Vaibhavi");
        mapResponse.put("firstName", "");
        mapResponse.put("lastName", "");
        mapResponse.put("email", "");
        mapResponse.put("password", "Vaibhavi123");
        mapResponse.put("phone", "");
        return mapResponse;
    }

}
