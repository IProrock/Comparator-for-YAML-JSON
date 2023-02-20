package hexlet.code.formatters;

import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

public class Stylish {

    public static String getFormattedString(Map<String, List<Object>> map) {

        StringJoiner resultStringJoiner = new StringJoiner("\n", "{\n", "\n}");

        for (Map.Entry<String, List<Object>> entry : map.entrySet()) {
            List<Object> value = entry.getValue();

            if (value.get(0).equals("add")) {
                resultStringJoiner.add("  + " + entry.getKey() + ": " + value.get(2));
            } else if (value.get(0).equals("rem")) {
                resultStringJoiner.add("  - " + entry.getKey() + ": " + value.get(1));
            } else if (value.get(0).equals("keep")) {
                resultStringJoiner.add("    " + entry.getKey() + ": " + value.get(1));
            } else if (value.get(0).equals("chg")) {
                resultStringJoiner.add("  - " + entry.getKey() + ": " + value.get(1));
                resultStringJoiner.add("  + " + entry.getKey() + ": " + value.get(2));
            }
        }

        return resultStringJoiner.toString();
    }
}
