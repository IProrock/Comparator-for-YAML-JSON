package hexlet.code;

import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.util.Map;

public class Formatter {

    public static String getFormatedString(Map<String, Map<String, Object>> resultMap, String format) {

        String result = "";

        if (format.equals("stylish")) {
            result = Stylish.getFormattedString(resultMap);
        } else if (format.equals("plain")) {
            result = Plain.getFormattedString(resultMap);
        } else if (format.equals("json")) {
            result = Json.getJsonFile(resultMap);
        }

        return result;
    }
}
