package hexlet.code;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Differ {

    public static String generate  (Path pathToFile1, Path pathToFile2) throws Exception {
        String result = "";
        if (!Files.exists(pathToFile1)) {
            throw new Exception("File " + pathToFile1 + " doesn't exist.");
        }
        if (!Files.exists(pathToFile2)) {
            throw new Exception("File " + pathToFile2 + " doesn't exist.");
        }

        Map<String, String> map1 = new HashMap<>();
        Map<String, String> map2 = new HashMap<>();
        Set<String> keys = new TreeSet<>();
        StringJoiner resultStringJoiner = new StringJoiner("\n", "{\n", "\n}");

        ObjectMapper mapper = new ObjectMapper();

        map1 = mapper.readValue(pathToFile1.toFile(), new TypeReference<Map<String,String>>(){});
        map2 = mapper.readValue(pathToFile2.toFile(), new TypeReference<Map<String,String>>(){});
        keys.addAll(map1.keySet());
        keys.addAll(map2.keySet());

        for (String key : keys) {
            if (!map1.containsKey(key)) {
                resultStringJoiner.add("  + " + key + ": " + map2.get(key));
            } else if (!map2.containsKey(key)) {
                resultStringJoiner.add("  - " + key + ": " + map1.get(key));
            } else {
                if ((map1.get(key)).equals(map2.get(key))) {
                    resultStringJoiner.add("    " + key + ": " + map1.get(key));
                } else {
                    resultStringJoiner.add("  - " + key + ": " + map1.get(key));
                    resultStringJoiner.add("  + " + key + ": " + map2.get(key));
                }
            }
        }

        return resultStringJoiner.toString();

    }
}
