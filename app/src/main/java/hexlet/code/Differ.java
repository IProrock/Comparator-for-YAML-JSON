package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class Differ {

    public static String generate(String file1, String file2, String format) throws Exception {

        Path pathToFile1 = Paths.get(file1).toAbsolutePath().normalize();
        Path pathToFile2 = Paths.get(file2).toAbsolutePath().normalize();

        if (!Files.exists(pathToFile1)) {
            throw new Exception("File " + pathToFile1 + " doesn't exist.");
        }
        if (!Files.exists(pathToFile2)) {
            throw new Exception("File " + pathToFile2 + " doesn't exist.");
        }

        Map<String, Object> parsedMap1 = Parser.parseToMap(Files.readString(pathToFile1), getDataType(file1));
        Map<String, Object> parsedMap2 = Parser.parseToMap(Files.readString(pathToFile2), getDataType(file2));
        Map<String, Map<String, Object>> comparedMap = Comparer.compareMaps(parsedMap1, parsedMap2);

        String result = Formatter.getFormattedStr(comparedMap, format);

        return result;
    }


    public static String generate(String file1, String file2) throws Exception {
        return generate(file1, file2, "stylish");
    }


    private static String getDataType(String pathToFile) {
        int indexOfExtension = pathToFile.lastIndexOf(".");

        return indexOfExtension > 0
                ? pathToFile.substring(indexOfExtension + 1)
                : "";
    }
}
