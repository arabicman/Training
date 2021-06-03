package codility.wordSum;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    //"Apple": 3.5
    //"Banana": 3.6
    //"Meat": 4.0
    //"Water": 3.9
    //"Coke": 3.1

    public static void main(String[] args) {
        Map<String,Double> map = new HashMap<>();
        map.put("Apple", 3.5);
        map.put("Banana", 3.6);
        map.put("Meat", 4.0);
        map.put("Water",3.9);
        map.put("Coke", 3.1);

        Solution sol = new Solution();
        Set<List<String>> listSet = sol.wordSum(map);
        for(List<String> ls : listSet){
            System.out.print('[');
            for (String s: ls){
                System.out.print(s + ",");
            }
            System.out.print("]");
            System.out.println();
        }


    }

    private Set<List<String>> wordSum(Map<String, Double> map) {
        Set<List<String>> res = new HashSet<>();
        if(map == null){
            return res;
        }
        Map<Double, List<String>> count = new HashMap<>();
        for(Map.Entry<String,Double> entry: map.entrySet()){
            count.putIfAbsent(entry.getValue(), new ArrayList<>());
            count.get(entry.getValue()).add(entry.getKey());
        }
        for(String s : map.keySet()){
            Double d = map.get(s);
            Double second = 7.0 - d;
            if(count.containsKey(second)){
                List<String> ls = count.get(second);
                for(String str : ls){
                    List<String> cur = new ArrayList<>();
                    cur.add(s);
                    cur.add(str);
                    cur.sort((a,b) -> a.compareTo(b));
                    res.add(cur);
                }
            }
        }
        return res;


    }

}
