package leetcode.algorithm.Q22_GenerateParentheses;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> generateParenthesis(int n) {

        List<String> res = new ArrayList<>();
        char[] cur = new char[n * 2];
        helper(cur, n, n, 0, res);
        return res;
    }

    private void helper(char[] cur, int left, int right, int index, List<String> res){
        if(left == 0 && right == 0){
            res.add(new String(cur));
            return;
        }
        if(left > 0){
            cur[index] = '(';
            helper(cur, left - 1, right, index+1, res);
        }
        if(right > left){
            cur[index] = ')';
            helper(cur, left, right - 1, index+1, res);
        }
    }
}
