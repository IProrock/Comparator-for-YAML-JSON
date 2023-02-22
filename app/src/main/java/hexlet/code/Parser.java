package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.nio.file.Path;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;

public class Parser {
    public static List<Map<String, Object>> parseToMap(Path pathToFile1, Path pathToFile2) throws Exception {

        Map<String, Object> parsedMap1 = new HashMap<>();
        Map<String, Object> parsedMap2 = new HashMap<>();
        List<Map<String, Object>> listOfParsedMaps = new ArrayList<Map<String, Object>>();

        ObjectMapper mapper = new ObjectMapper();

        if (pathToFile1.toString().endsWith(".yml")) {
            mapper = new YAMLMapper();
        }

        parsedMap1 = mapper.readValue(pathToFile1.toFile(), new TypeReference<Map<String, Object>>() { });
        parsedMap2 = mapper.readValue(pathToFile2.toFile(), new TypeReference<Map<String, Object>>() { });
        listOfParsedMaps.add(parsedMap1);
        listOfParsedMaps.add(parsedMap2);

        return listOfParsedMaps;
    }
}
