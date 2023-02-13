package hexlet.code;

import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.TreeSet;

public class Comparer {

    public static Map<String, Object> compareMaps(Map<String, Object> map1, Map<String, Object> map2) {

        Set<String> keys = new TreeSet<>();
        Map<String, Object> comparedMap = new LinkedHashMap<>();

        keys.addAll(map1.keySet());
        keys.addAll(map2.keySet());


        for (String key : keys) {
            if (map1.containsKey(key) && map1.get(key) == null) {
                map1.put(key, "null");
            }
            if (map2.containsKey(key) && map2.get(key) == null) {
                map2.put(key, "null");
            }

            if (!map1.containsKey(key)) {
                comparedMap.put("  + " + key, map2.get(key));
            } else if (!map2.containsKey(key)) {
                comparedMap.put("  - " + key, map1.get(key));
            } else {
                if ((map1.get(key)).equals(map2.get(key))) {
                    comparedMap.put("    " + key, map1.get(key));
                } else {
                    comparedMap.put("  - " + key, map1.get(key));
                    comparedMap.put("  + " + key, map2.get(key));
                }
            }
        }
        return comparedMap;
    }
}
