package leetcode.algorithm.Q890_FindAndReplacePattern;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        String pattern1 = patternTo(pattern);
        List<String> res = new ArrayList<>();
        for(String w : words){
            if(patternTo(w).equals(pattern1)){
                res.add(w);
            }
        }
        return res;


    }

    public String patternTo(String str){
        if(str.length() <= 1){
            return str;
        }
        Map<Character, Character> map = new HashMap<>();
        short count = 0;
        char[] arr = new char[str.length()];
        for(int i = 0; i < str.length(); i++){
            Character cur = map.get(str.charAt(i));
            if(cur == null){
                map.put(str.charAt(i),(char) ('a'+ count));
                arr[i] = (char)('a' + count);
                count++;
            }else{
                arr[i] = cur;
            }
        }

        return new String(arr);
    }

    public static void main(String[] args) {
        Solution solu = new Solution();
//        String s1 = solu.patternTo("abc");
//        String s2 = solu.patternTo("bdsdsd");
//        System.out.println(s1+", "+ s2);
        String[] input = {"abc","deq","mee","aqq","dkd","ccc"};
        String pattern = "abb";
        List<String> list = solu.findAndReplacePattern(input, pattern);
        list.stream().forEach(System.out::println);
    }
}
