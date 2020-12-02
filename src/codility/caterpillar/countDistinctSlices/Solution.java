package codility.caterpillar.countDistinctSlices;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int solution(int M, int[] A){

        boolean[] dedup = new boolean[M+1];
        int l = 0;
        int r = 0;
        int cnt = 0;

        while(l < A.length && r < A.length){
            if(dedup[A[r]] == false){
                cnt = cnt + (r - l + 1); //已经包含了所有可能性
                if(cnt >= Integer.MAX_VALUE){
                    return Integer.MAX_VALUE;
                }
                dedup[A[r]] = true;
                r++;
            }else{
                dedup[A[l]] = false;
                l++;
            }
        }
        return cnt;
    }
}
