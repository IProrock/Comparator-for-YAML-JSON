package hexlet.code.formatters;

import java.util.Map;
import java.util.StringJoiner;

public class Stylish {

    public static String getFormattedString(Map<String, Map<String, Object>> map) {

        StringJoiner resultStringJoiner = new StringJoiner("\n", "{\n", "\n}");

        for (Map.Entry<String, Map<String, Object>> entry : map.entrySet()) {
            Map<String, Object> value = entry.getValue();

            if (value.get("Status").equals("added")) {
                resultStringJoiner.add("  + " + entry.getKey() + ": " + value.get("New value"));
            } else if (value.get("Status").equals("removed")) {
                resultStringJoiner.add("  - " + entry.getKey() + ": " + value.get("Old value"));
            } else if (value.get("Status").equals("unchanged")) {
                resultStringJoiner.add("    " + entry.getKey() + ": " + value.get("Old value"));
            } else if (value.get("Status").equals("changed")) {
                resultStringJoiner.add("  - " + entry.getKey() + ": " + value.get("Old value"));
                resultStringJoiner.add("  + " + entry.getKey() + ": " + value.get("New value"));
            }
        }

        return resultStringJoiner.toString();
    }
}
