package hexlet.code;

import java.util.Map;
import java.util.Set;
import java.util.StringJoiner;
import java.util.TreeSet;

public class Comparer {

    public static String compareMaps(Map<String, String> map1, Map<String, String> map2) {

        Set<String> keys = new TreeSet<>();
        keys.addAll(map1.keySet());
        keys.addAll(map2.keySet());
        StringJoiner resultStringJoiner = new StringJoiner("\n", "{\n", "\n}");

        for (String key : keys) {
            if (!map1.containsKey(key)) {
                resultStringJoiner.add("  + " + key + ": " + map2.get(key));
            } else if (!map2.containsKey(key)) {
                resultStringJoiner.add("  - " + key + ": " + map1.get(key));
            } else {
                if ((map1.get(key)).equals(map2.get(key))) {
                    resultStringJoiner.add("    " + key + ": " + map1.get(key));
                } else {
                    resultStringJoiner.add("  - " + key + ": " + map1.get(key));
                    resultStringJoiner.add("  + " + key + ": " + map2.get(key));
                }
            }
        }
        return resultStringJoiner.toString();
    }
}
