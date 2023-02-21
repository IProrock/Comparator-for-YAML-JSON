package hexlet.code.formatters;

import java.util.Collection;
import java.util.Map;
import java.util.StringJoiner;

public class Plain {

    public static String getFormattedString(Map<String, Map<String, Object>> map) {
        String result = "";
        StringJoiner resultStringJoiner = new StringJoiner("\n");

        for (Map.Entry<String, Map<String, Object>> entry : map.entrySet()) {

            Object val1 = "";
            Object val2 = "";

            if ((entry.getValue().get("Old value") instanceof Collection<?>)
                    || (entry.getValue().get("Old value") instanceof Map<?, ?>))  {
                val1 = "[complex value]";
            } else {
                val1 = entry.getValue().get("Old value");
            }

            if ((entry.getValue().get("New value") instanceof Collection<?>)
                    || (entry.getValue().get("New value") instanceof Map<?, ?>)) {
                val2 = "[complex value]";
            } else {
                val2 = entry.getValue().get("New value");
            }

            if (entry.getValue().get("Old value") instanceof String) {
                val1 = "'" + val1 + "'";
            }

            if (entry.getValue().get("New value") instanceof  String) {
                val2 = "'" + val2 + "'";
            }



            if (entry.getValue().get("Status").equals("changed")) {
                resultStringJoiner.add("Property '" + entry.getKey() + "' was updated. From " + val1 + " to " + val2);
            } else if (entry.getValue().get("Status").equals("removed")) {
                resultStringJoiner.add("Property '" + entry.getKey() + "' was removed");
            } else if (entry.getValue().get("Status").equals("added")) {
                resultStringJoiner.add("Property '" + entry.getKey() + "' was added with value: " + val2);
            }

        }
        return resultStringJoiner.toString();

    }
}
