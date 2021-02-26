package leetcode.algorithm.Q784_LetterCasePermutation;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> letterCasePermutation(String S) {

        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        helper(S, sb, 0, res);
        return res;

    }

    private void helper(String str, StringBuilder sb, int index, List<String> res){
        if(index == str.length()){
            res.add(sb.toString());
            return;
        }
        char cur = str.charAt(index);
        if(Character.isLetter(cur)){
            sb.append(Character.toLowerCase(cur));
            helper(str, sb, index+1, res);
            sb.deleteCharAt(sb.length() - 1);
            sb.append(Character.toUpperCase(cur));
            helper(str, sb, index+1, res);
            sb.deleteCharAt(sb.length() - 1);

        }else{
            sb.append(cur);
            helper(str, sb, index+1, res);
            sb.deleteCharAt(sb.length() - 1);
        }
        return;
    }



}
