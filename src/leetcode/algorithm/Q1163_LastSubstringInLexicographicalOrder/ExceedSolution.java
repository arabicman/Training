package leetcode.algorithm.Q1163_LastSubstringInLexicographicalOrder;

public class ExceedSolution {
    public String lastSubstring(String s) {
        if(s.length() == 1){
            return s;
        }
        //find max character;
        char max = 'a';
        for (int i = 0; i < s.length(); i++){
            if(s.charAt(i) > max){
                max = s.charAt(i);
            }
        }
        int start = s.indexOf(max);
        String curMax = s.substring(start);
        for(int i = start + 1; i < s.length(); i++){
            if(s.charAt(i) == max){
                String cur = s.substring(i);
                int res = curMax.compareTo(cur);
                if(res < 0){
                    curMax = cur;
                }else {
                    curMax = curMax;
                }
                while(i < s.length() -1 && s.charAt(i+1) == s.charAt(i)){
                    i++;
                }
            }
        }
        return curMax;
    }



}


