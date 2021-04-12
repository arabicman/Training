package leetcode.algorithm.Q1282_GroupThePeopleGivenTheGroupSize;

import java.util.*;

public class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(groupSizes == null ){
            return res;
        }
        Map<Integer, Queue<Integer>> map = new HashMap<>();
        for(int i = 0; i < groupSizes.length; i++){
            Queue<Integer> q = map.get(groupSizes[i]);
            if(q == null){
                map.put(groupSizes[i], new LinkedList<>());
                map.get(groupSizes[i]).offer(i);
            }else{
                q.offer(i);
            }
        }
        for(Map.Entry<Integer, Queue<Integer>> entry: map.entrySet() ){
            Integer cur = entry.getKey();
            while(entry.getValue().size() != 0){
                List<Integer> temp = new ArrayList<>();
                int times = cur;
                while(times > 0){
                    temp.add(entry.getValue().poll());
                    times --;
                }
                res.add(temp);
            }
        }
        return res;
    }
}
