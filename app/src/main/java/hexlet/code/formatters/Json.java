package hexlet.code.formatters;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;


public class Json {

    public static String getFormattedString(Map<String, Map<String, Object>> map) {

        ObjectMapper mapper = new ObjectMapper();
        String mapToJsonString = "";

        try {
            mapToJsonString = mapper.writeValueAsString(map);
        } catch (Exception e) {
            return "Error while exporting to file.";
        }
        return mapToJsonString;
    }
}
