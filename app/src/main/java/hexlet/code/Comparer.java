package hexlet.code;

import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;
import java.util.LinkedHashMap;
import java.util.Objects;

public class Comparer {

    public static Map<String, Map<String, Object>> compareMaps(Map<String, Object> map1, Map<String, Object> map2) {

        Set<String> keys = new TreeSet<>();
        Map<String, Map<String, Object>> comparedMap = new LinkedHashMap<>();

        keys.addAll(map1.keySet());
        keys.addAll(map2.keySet());

        for (String key : keys) {

            if (!map1.containsKey(key)) {
                Map<String, Object> condition = new HashMap<>();
                condition.put("Status", "added");
                condition.put("Old value", null);
                condition.put("New value", map2.get(key));
                comparedMap.put(key, condition);

            } else if (!map2.containsKey(key)) {
                Map<String, Object> condition = new HashMap<>();
                condition.put("Status", "removed");
                condition.put("Old value", map1.get(key));
                condition.put("New value", null);
                comparedMap.put(key, condition);

            } else {
                if (Objects.equals((map1.get(key)), (map2.get(key)))) {
                    Map<String, Object> condition = new HashMap<>();
                    condition.put("Status", "unchanged");
                    condition.put("Old value", map1.get(key));
                    condition.put("New value", map2.get(key));
                    comparedMap.put(key, condition);

                } else {
                    Map<String, Object> condition = new HashMap<>();
                    condition.put("Status", "changed");
                    condition.put("Old value", map1.get(key));
                    condition.put("New value", map2.get(key));
                    comparedMap.put(key, condition);
                }
            }
        }
        return comparedMap;
    }
}
