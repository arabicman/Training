package leetcode.algorithm.Q1614_MaximumNestingDepthOfTheParentheses;

import java.util.LinkedList;
import java.util.Stack;

public class Solution {
    public int maxDepth(String s) {
        Stack<Character> stack = new Stack<>();
        int res = 0;
        for(int i = 0; i < s.length(); i ++){
            char cur = s.charAt(i);
            if(cur == ')'){
                if(!stack.isEmpty()){
                    stack.pop();
                }else{
                    return -1;
                }
            }else if(cur == '('){
                stack.push(cur);
            }
            res = Math.max(res, stack.size());
        }
        return res;
    }

}
