package hexlet.code;

import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.util.List;
import java.util.Map;

public class Formatter {

    public static String getFormatedString(Map<String, List<Object>> resultMap, String format) {

        String result = "";

        if (format.equals("stylish")) {
            result = Stylish.getFormattedString(resultMap);
        } else if (format.equals("plain")) {
            result = Plain.getFormattedString(resultMap);
        }

        return result;
    }
}
