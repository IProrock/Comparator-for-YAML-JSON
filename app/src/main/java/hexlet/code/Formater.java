package hexlet.code;

import java.util.Map;
import java.util.StringJoiner;

public class Formater {

    public static String getFormatedString(Map<String, Object> map, String format) {

        System.out.println(format);

        StringJoiner resultStringJoiner = new StringJoiner("\n", "{\n", "\n}");

        for (Map.Entry<String, Object> entry : map.entrySet()) {
            resultStringJoiner.add(entry.getKey() + ": " + entry.getValue());
        }

        return resultStringJoiner.toString();
    }
}
