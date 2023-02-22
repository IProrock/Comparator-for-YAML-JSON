package hexlet.code.formatters;

import java.util.Collection;
import java.util.Map;
import java.util.StringJoiner;

public class Plain {

    public static String getFormattedString(Map<String, Map<String, Object>> map) {
        String result = "";
        StringJoiner resultStringJoiner = new StringJoiner("\n");

        for (Map.Entry<String, Map<String, Object>> entry : map.entrySet()) {

            Object oVal = "";
            Object nVal = "";

            if ((entry.getValue().get("Old value") instanceof Collection<?>)
                    || (entry.getValue().get("Old value") instanceof Map<?, ?>))  {
                oVal = "[complex value]";
            } else {
                oVal = entry.getValue().get("Old value");
            }

            if ((entry.getValue().get("New value") instanceof Collection<?>)
                    || (entry.getValue().get("New value") instanceof Map<?, ?>)) {
                nVal = "[complex value]";
            } else {
                nVal = entry.getValue().get("New value");
            }

            if (entry.getValue().get("Old value") instanceof String) {
                oVal = "'" + oVal + "'";
            }

            if (entry.getValue().get("New value") instanceof  String) {
                nVal = "'" + nVal + "'";
            }



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
}
