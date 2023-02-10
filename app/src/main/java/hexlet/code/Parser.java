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
    public static List<Map<String, String>> parseToMap(Path pathToFile1, Path pathToFile2) throws Exception {

        Map<String, String> map1 = new HashMap<>();
        Map<String, String> map2 = new HashMap<>();
        List<Map<String, String>> result = new ArrayList<Map<String, String>>();

        ObjectMapper mapper = new ObjectMapper();

        if (pathToFile1.toString().endsWith(".yml")) {
            mapper = new YAMLMapper();
        }

        map1 = mapper.readValue(pathToFile1.toFile(), new TypeReference<Map<String, String>>() { });
        map2 = mapper.readValue(pathToFile2.toFile(), new TypeReference<Map<String, String>>() { });
        result.add(map1);
        result.add(map2);

        return result;
    }
}
