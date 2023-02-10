package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class Differ {

    public static String generate(String file1, String file2) throws Exception {
        Path pathToFile1 = Paths.get(file1).toAbsolutePath().normalize();
        Path pathToFile2 = Paths.get(file2).toAbsolutePath().normalize();
        String result = "";

        if (!Files.exists(pathToFile1)) {
            throw new Exception("File " + pathToFile1 + " doesn't exist.");
        }
        if (!Files.exists(pathToFile2)) {
            throw new Exception("File " + pathToFile2 + " doesn't exist.");
        }

        List<Map<String, String>> parsedListOfMaps = Parser.parseToMap(pathToFile1, pathToFile2);
        result = Comparer.compareMaps(parsedListOfMaps.get(0), parsedListOfMaps.get(1));

        return result;
    }
}
