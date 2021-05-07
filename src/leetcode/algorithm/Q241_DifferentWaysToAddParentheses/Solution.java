package leetcode.algorithm.Q241_DifferentWaysToAddParentheses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public List<Integer> diffWaysToCompute(String expression) {
        //cache
        Map<String, List<Integer>> cache = new HashMap<>();
        return helper(expression, cache);
    }

    private List<Integer> helper(String s, Map<String, List<Integer>> cache){

        if (cache.get(s) != null){
            return cache.get(s);
        }
        boolean expression = false;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < s.length(); i ++){
            if("+-*".indexOf(s.charAt(i)) != -1){
                List<Integer> left = helper(s.substring(0,i),cache);
                List<Integer> right = helper(s.substring(i + 1), cache);
                for (Integer l : left){
                    for (Integer r : right){
                        res.add(cal(l, r, s.charAt(i)));
                    }
                }
                expression = true;
            }
        }
        if (!expression){
            res.add(Integer.parseInt(s));
        }
        cache.put(s, res);
        return res;
    }

    private int cal(int l, int r, char op){
        int res = 0;
        switch (op) {
            case '+': res = l + r; break;
            case '-': res = l - r; break;
            case '*': res = l * r; break;
            default: break;
        }
        return res;
    }
}
