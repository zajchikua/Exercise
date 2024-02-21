package CollectionsExercise;

import java.util.Map;
import java.util.HashMap;

public class MergeTwoHashes {
    public static void mergeMaps ( Map< String, Integer > map1, Map< String, Integer > map2 ) {
        // If key exists in map1, add values; otherwise, add the entry
        for(Map.Entry< String, Integer > entry : map2.entrySet()){
            String key= entry.getKey();
            Integer val = entry.getValue();
         if(map1.containsKey(key)){
             map1.put(key, val + map1.get(key));
         }
         else map1.put(key, val);

        }
    }

    public static void main ( String[] args ) {
        Map< String, Integer > map1 = new HashMap<>();
        map1.put("student", 3);
        map1.put("parent", 2);

        Map< String, Integer > map2 = new HashMap<>();
        map2.put("student", 1);
        map2.put("teacher", 5);

        // Merge map2 into map1
        mergeMaps(map1, map2);

        // Display the merged map
        System.out.println("Merged Map: " + map1);
    }

}
