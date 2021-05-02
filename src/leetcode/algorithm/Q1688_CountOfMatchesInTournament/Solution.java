package leetcode.algorithm.Q1688_CountOfMatchesInTournament;

public class Solution {
    public int numberOfMatches(int n) {
        int res = 0;
        while (n > 1){
            res += n/2;
            n = n%2 == 0 ? n/2 : n/2 + 1 ;
        }
        return res;
    }
}
