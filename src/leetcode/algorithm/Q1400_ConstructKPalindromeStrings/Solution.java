package leetcode.algorithm.Q1400_ConstructKPalindromeStrings;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean canConstruct(String s, int k) {
        if(s.length() < k){
            return false;
        }
        if(s.length() == k){
            return true;
        }
        int countOdd = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char cur = s.charAt(i);
            Integer x = map.get(cur);
            if(x == null){
                map.put(cur, 1);
            }else{
                map.put(cur, x+1);
            }
        }
        for(Integer val: map.values()){
            if(val % 2 == 1){
                countOdd ++;
            }
        }
        if(countOdd <= k){
            return true;
        }
            return false;

    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "leetcode";
        int k = 3;
        boolean res  = sol.canConstruct(s,k);
        System.out.println(res);
    }
}
