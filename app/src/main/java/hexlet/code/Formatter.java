package hexlet.code;

import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.util.Map;

public class Formatter {

    public static String getFormatedString(Map<String, Map<String, Object>> comparedMap, String format) {

        String result = "";

        if (format.equals("stylish")) {
            result = Stylish.getFormattedString(comparedMap);

        } else if (format.equals("plain")) {
            result = Plain.getFormattedString(comparedMap);

        } else if (format.equals("json")) {
            result = Json.getFormattedString(comparedMap);
        }

        return result;
    }
}
