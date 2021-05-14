package leetcode.algorithm.Q1857_LargestColorValueInADirectedGraph;

import java.util.*;

public class TimeExceedSolution {
    public int largestPathValue(String colors, int[][] edges) {
        if(colors.length() == 1 && edges.length == 0){
            return 1;
        }

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] arr : edges) {
            List<Integer> cur = map.get(arr[0]);
            if (cur == null) {
                map.put(arr[0], new ArrayList<>());
                map.get(arr[0]).add(arr[1]);
            } else {
                map.get(arr[0]).add(arr[1]);
            }
        }
        int res = 0;

        for(Integer key: map.keySet()){
            int[] colorArr = new int[26];
            colorArr[colors.charAt(key) - 'a'] ++;
            Set<Integer> path = new HashSet<>();
            path.add(key);
            boolean[] flag = new boolean[]{false};
            res = Math.max(res,pathMax(key, map,colors, colorArr, path, flag));
            if(flag[0]){
                return -1;
            }
        }
        return res;

    }

    private int pathMax(int cur, Map<Integer, List<Integer>> map,
                        String color, int[] colors, Set<Integer> path, boolean[] flag){

        List<Integer> list = map.get(cur);
        if(list == null || list.isEmpty()){
            int max = 0;
            for(int i : colors){
                max = Math.max(max, i);
            }
            return max;
        }
        int res = 0;
        for(int i : list){
            //cycle
            if(path.contains(i)){
                flag[0] = true;
                return -1;
            }
            path.add(i);
            colors[color.charAt(i)- 'a'] ++;
            int tmp  = pathMax(i, map, color, colors, path, flag);
            res = Math.max(res, tmp);
            colors[color.charAt(i) - 'a'] --;
            path.remove(i);
        }
        return res;
    }


}
