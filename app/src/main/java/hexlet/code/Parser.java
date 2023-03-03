package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.util.Map;

public class Parser {
    public static Map<String, Object> parseToMap(String dataToParse, String dataType) throws Exception {

        ObjectMapper mapper;

        switch (dataType) {
            case "json":
                mapper = new ObjectMapper();
                break;

            case "yml": case "yaml":
                mapper = new YAMLMapper();
                break;

            default:
                throw new Exception("Unknown file extension: " + dataType);
        }

        Map<String, Object> parsedMap = mapper.readValue(dataToParse, new TypeReference<Map<String, Object>>() { });

        return parsedMap;
    }
}
