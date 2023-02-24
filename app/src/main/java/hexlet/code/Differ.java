package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class Differ {

    public static String generate(String file1, String file2, String format) throws Exception {

        Path pathToFile1 = Paths.get(file1).toAbsolutePath().normalize();
        Path pathToFile2 = Paths.get(file2).toAbsolutePath().normalize();
        Map<String, Object> parsedMap1;
        Map<String, Object> parsedMap2;
        Map<String, Map<String, Object>> comparedMap;
        String result = "";

        if (!Files.exists(pathToFile1)) {
            throw new Exception("File " + pathToFile1 + " doesn't exist.");
        }
        if (!Files.exists(pathToFile2)) {
            throw new Exception("File " + pathToFile2 + " doesn't exist.");
        }

        parsedMap1 = Parser.parseToMap(Files.readString(pathToFile1), getDataType(file1));
        parsedMap2 = Parser.parseToMap(Files.readString(pathToFile2), getDataType(file2));
        comparedMap = Comparer.compareMaps(parsedMap1, parsedMap2);

        result = Formatter.getFormattedStr(comparedMap, format);

        return result;
    }


    public static String generate(String file1, String file2) throws Exception {
        return generate(file1, file2, "stylish");
    }


    private static String getDataType(String dataSource) {
        String dataType = "json";

        if (dataSource.endsWith("yml")) {
            dataType = "yml";
        }
        return dataType;
    }
}
