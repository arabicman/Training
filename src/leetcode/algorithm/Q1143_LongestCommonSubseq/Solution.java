package leetcode.algorithm.Q1143_LongestCommonSubseq;

public class Solution {
    public int longestCommonSubsequence(String text1, String text2) {

        int[][] longest = new int[text1.length()+1][text2.length()+1];
        for(int i = 1; i <= text1.length(); i++){
            for(int j = 1; j <= text2.length(); j++){
                if(text1.charAt(i - 1) == text2.charAt(j - 1)){
                    longest[i][j] = longest[i - 1][j - 1] + 1;
                }else{
                    longest[i][j] = Math.max(longest[i-1][j], longest[i][j-1]);
                }
            }
        }
        return longest[text1.length()][text2.length()];
    }
}
