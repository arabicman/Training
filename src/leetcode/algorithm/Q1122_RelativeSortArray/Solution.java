package leetcode.algorithm.Q1122_RelativeSortArray;

import java.util.*;

public class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> cnt = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        List<Integer> tail = new ArrayList<>();
        for(int i : arr2){
            set.add(i);
        }
        for(int i : arr1){
            if(!set.contains(i)){
                tail.add(i);
            }else{
                Integer cur = cnt.get(i);
                if(cur == null){
                    cnt.put(i, 1);
                }else{
                    cnt.put(i, cur+1);
                }
            }
        }
        int[] arr3 = new int[arr1.length];
        int pt = 0;
        for(int i = 0; i < arr2.length; i++){
                int times = cnt.get(arr2[i]);
                while(times > 0){
                    arr3[pt++] = arr2[i];
                    times --;
                }
        }
        Collections.sort(tail);
        for(int i = 0; i < tail.size(); i++){
            arr3[pt++] = tail.get(i);
        }
        return arr3;
    }
}
