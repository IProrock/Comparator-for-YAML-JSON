package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class Differ {

    public static String generate(String file1, String file2, String format) throws Exception {

        Path pathToFile1 = Paths.get(file1).toAbsolutePath().normalize();
        Path pathToFile2 = Paths.get(file2).toAbsolutePath().normalize();
        Map<String, Map<String, Object>> comparedMap;
        String result = "";

        if (!Files.exists(pathToFile1)) {
            throw new Exception("File " + pathToFile1 + " doesn't exist.");
        }
        if (!Files.exists(pathToFile2)) {
            throw new Exception("File " + pathToFile2 + " doesn't exist.");
        }

        List<Map<String, Object>> listOfParsedMaps = Parser.parseToMap(pathToFile1, pathToFile2);
        comparedMap = Comparer.compareMaps(listOfParsedMaps.get(0), listOfParsedMaps.get(1));
        result = Formatter.getFormatedString(comparedMap, format);

        return result;
    }

    public static String generate(String file1, String file2) throws Exception {
        return generate(file1, file2, "stylish");
    }
}
