package hexlet.code.formatters;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

public class Plain {

    public static String getFormattedString(Map<String, List<Object>> map) {
        String result = "";
        StringJoiner resultStringJoiner = new StringJoiner("\n");

        for (Map.Entry<String, List<Object>> entry : map.entrySet()) {

            Object val1 = "";
            Object val2 = "";

            if ((entry.getValue().get(1) instanceof Collection<?>) || (entry.getValue().get(1) instanceof Map<?, ?>))  {
                val1 = "[complex value]";
            } else {
                val1 = entry.getValue().get(1);
            }

            if ((entry.getValue().get(2) instanceof Collection<?>) || (entry.getValue().get(2) instanceof Map<?, ?>)) {
                val2 = "[complex value]";
            } else {
                val2 = entry.getValue().get(2);
            }

            if (entry.getValue().get(1) instanceof String) {
                val1 = "'" + val1 + "'";
            }

            if (entry.getValue().get(2) instanceof  String) {
                val2 = "'" + val2 + "'";
            }



            if (entry.getValue().get(0).equals("chg")) {
                resultStringJoiner.add("Property '" + entry.getKey() + "' was updated. From " + val1 + " to " + val2);
            } else if (entry.getValue().get(0).equals("rem")) {
                resultStringJoiner.add("Property '" + entry.getKey() + "' was removed");
            } else if (entry.getValue().get(0).equals("add")) {
                resultStringJoiner.add("Property '" + entry.getKey() + "' was added with value: " + val2);
            }

        }
        return resultStringJoiner.toString();

    }
}
