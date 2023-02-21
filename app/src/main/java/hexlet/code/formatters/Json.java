package hexlet.code.formatters;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.Map;
import java.util.StringJoiner;

public class Json {

    public static String getJsonFile(Map<String, Map<String, Object>> map) {

        ObjectMapper mapper = new ObjectMapper();
        String mapToJsonString = "";
        Path pathToResultFolder = Paths.get("./comparedJson");
        StringJoiner stringJoiner = new StringJoiner("\n", "{\n", "");

        try {
            Files.createDirectory(pathToResultFolder);
        } catch (Exception e) {
            System.out.println("Folder already exists");
        }

        Path pathToJson = Paths.get("./comparedJson/compared.json");

        try {
            Files.createFile(pathToJson);
        } catch (Exception e) {
            System.out.println("File 'compared.json' rewrited by new one");
        }

        try {
            mapToJsonString = mapper.writeValueAsString(map);
            mapper.writeValue(pathToJson.toFile(), map);
        } catch (Exception e) {
            return "Error while exporting to file.";
        }


        return mapToJsonString;
    }
}
