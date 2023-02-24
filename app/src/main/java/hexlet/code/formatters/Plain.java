package hexlet.code.formatters;

import java.util.Map;
import java.util.List;
import java.util.StringJoiner;

public class Plain {

    public static String getFormattedString(Map<String, Map<String, Object>> map) {

        StringJoiner resultStringJoiner = new StringJoiner("\n");

        for (Map.Entry<String, Map<String, Object>> entry : map.entrySet()) {

            String oVal = stringify(entry.getValue().get("Old value"));
            Object nVal = stringify(entry.getValue().get("New value"));

            if (entry.getValue().get("Status").equals("changed")) {
                resultStringJoiner.add("Property '" + entry.getKey() + "' was updated. From " + oVal + " to " + nVal);

            } else if (entry.getValue().get("Status").equals("removed")) {
                resultStringJoiner.add("Property '" + entry.getKey() + "' was removed");

            } else if (entry.getValue().get("Status").equals("added")) {
                resultStringJoiner.add("Property '" + entry.getKey() + "' was added with value: " + nVal);
            }
        }
        return resultStringJoiner.toString();
    }

    private static String stringify(Object value) {

        if (value == null) {
            return "null";
        }

        if (value instanceof String) {
            return ("'" + value + "'");
        }

        if (value instanceof Map || value instanceof List) {
            return "[complex value]";
        }

        return value.toString();
    }
}
