package leetcode.algorithm.Q1255_MaximumScoreWordsFormedByLetters;

public class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {

        int[] cnt = new int[26];
        for(char ch: letters){
            cnt[ch - 'a'] ++;
        }
        int[][] matrix = new int[words.length][26];
        for(int i = 0; i < words.length; i++){
            for(int j = 0; j < words[i].length(); j++){
                matrix[i][words[i].charAt(j)-'a']++;
            }
        }
        return findMax(matrix, 0, cnt, score);
    }

    private int findMax(int[][] matrix, int idx, int[] cnt, int[] score) {
        if(idx == matrix.length) return 0;
        int[] curCnt = new int[26];
        int res = findMax(matrix, idx+1, cnt, score );
        int curScore = 0;
        for (int j = 0; j < 26; j++) {
            curScore += score[j] * matrix[idx][j];
            curCnt[j] = cnt[j] - matrix[idx][j];
            if(curCnt[j] < 0) return res;
        }
        int add = curScore + findMax(matrix, idx + 1, curCnt, score);
        return Math.max(res, add);

    }


}
