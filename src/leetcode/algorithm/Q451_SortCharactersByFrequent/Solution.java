package leetcode.algorithm.Q451_SortCharactersByFrequent;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
        String s = "aaacc";
        Solution sol = new Solution();
        System.out.println(sol.frequencySort(s));
    }
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            Integer cur = map.get(s.charAt(i));
            if(cur == null){
                map.put(s.charAt(i), 1);
            }else{
                map.put(s.charAt(i), cur+1);
            }
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>(map.size(), (a,b)->Integer.compare(b.cnt,a.cnt));
        for(Map.Entry<Character,Integer> entry: map.entrySet()){
            pq.offer(new Pair(entry.getKey(),entry.getValue()));
        }
        StringBuilder sb = new StringBuilder();
        while(pq.size() > 0){
            Pair p = pq.poll();
            for(int i = p.cnt; i > 0; i--) sb.append(p.val);
        }
        return sb.toString();

    }

    class Pair{
        char val;
        int cnt;
        public Pair(char val, int cnt){
            this.val = val;
            this.cnt = cnt;
        }
    }
}
