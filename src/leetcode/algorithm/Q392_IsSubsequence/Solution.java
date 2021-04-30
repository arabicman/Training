package leetcode.algorithm.Q392_IsSubsequence;

public class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.length() < 1){
            return true;
        }
        if(t.length() < 1){
            return false;
        }

        int si = 0;
        int ti = 0;
        while(ti < t.length()){
            if(si == s.length()-1 && s.charAt(si) == t.charAt(ti)){
                return true;
            }else if( s.charAt(si) == t.charAt(ti) ){
                si ++;
                ti ++;
            }else{
                ti ++;
            }
        }
        return false;
    }


}
