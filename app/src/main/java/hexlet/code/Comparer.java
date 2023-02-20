package hexlet.code;

import java.util.Map;
import java.util.Set;
import java.util.List;
import java.util.TreeSet;
import java.util.LinkedHashMap;
import java.util.ArrayList;
import java.util.Objects;

public class Comparer {

    public static Map<String, List<Object>> compareMaps(Map<String, Object> map1, Map<String, Object> map2) {

        Set<String> keys = new TreeSet<>();
        Map<String, List<Object>> comparedMap = new LinkedHashMap<>();

        keys.addAll(map1.keySet());
        keys.addAll(map2.keySet());


        for (String key : keys) {

            if (!map1.containsKey(key)) {
                List<Object> condition = new ArrayList<>();
                condition.add("add");
                condition.add(null);
                condition.add(map2.get(key));
                comparedMap.put(key, condition);

            } else if (!map2.containsKey(key)) {
                List<Object> condition = new ArrayList<>();
                condition.add("rem");
                condition.add(map1.get(key));
                condition.add(null);
                comparedMap.put(key, condition);

            } else {
                if (Objects.equals((map1.get(key)), (map2.get(key)))) {
                    List<Object> condition = new ArrayList<>();
                    condition.add("keep");
                    condition.add(map1.get(key));
                    condition.add(null);
                    comparedMap.put(key, condition);

                } else {
                    List<Object> condition = new ArrayList<>();
                    condition.add("chg");
                    condition.add(map1.get(key));
                    condition.add(map2.get(key));
                    comparedMap.put(key, condition);

                }
            }
        }
        return comparedMap;
    }
}
