package hexlet.code;

import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.util.Map;

public class Formatter {

    public static String getFormattedStr(Map<String, Map<String, Object>> comparedMap, String format) throws Exception {

        switch (format) {
            case "stylish":
                return Stylish.getFormattedString(comparedMap);

            case "plain":
                return Plain.getFormattedString(comparedMap);

            case "json":
                return Json.getFormattedString(comparedMap);

            default:
                throw new Exception("Unknown format: " + format);
        }
    }
}
