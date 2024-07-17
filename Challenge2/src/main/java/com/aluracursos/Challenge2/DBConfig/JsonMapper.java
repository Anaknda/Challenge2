package Challenge2.DBConfig;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonMapper {
    private ObjectMapper objectMapper;

    public JsonMapper() {
        objectMapper = new ObjectMapper();
    }

    public <T> T mapJson(String json, Class<T> clazz) {
        try {
            return objectMapper.readValue(json, clazz);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
