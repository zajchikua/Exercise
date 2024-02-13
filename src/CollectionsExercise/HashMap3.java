package CollectionsExercise;

import com.sun.jdi.Value;

import java.util.HashMap;
import java.util.Map;

public class HashMap3 {
    public static Map<Integer, Integer> mergeTwoHM ( Map <Integer, Integer> first,
                                                         Map <Integer, Integer> sec ) {

    HashMap<Integer, Integer> merged = new HashMap<>(first);

    sec.forEach ((key, value) -> merged.merge( key, value, Integer :: sum));

    return first;
    }

    public static Map<Integer,Integer > mergeTwoHM2( Map <Integer, Integer> first,
                                              Map <Integer, Integer> sec )
    {
        for(Map.Entry<Integer, Integer> entry : sec.entrySet()){
            int key = entry.getKey() ;
            int value = entry.getValue();
            if(first.containsKey(key)){
                first.put(key, first.get(key) + value);
            }
            else
                first.put(key,first.getOrDefault(key, 0) +1);
        }

        return  first;
    }
    public static void main ( String[] args ) {
            Map<Integer, Integer> map1 = new HashMap<>();
            map1.put(1, 3);
            map1.put(2, 2);
            map1.put(4, 10);
            map1.put(5, 9);

            Map<Integer, Integer> map2 = new HashMap<>();
            map2.put(2, 1);
            map2.put(3, 5);
        System.out.println(mergeTwoHM2(map1, map2));
            //System.out.println(mergeTwoHM(map2,map1));
    }
}
