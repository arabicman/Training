package codility.prime_and_composite.Peaks;
/*
*  https://app.codility.com/programmers/lessons/Sol/peaks/
* 核心代码：   for(int peaksIndex : peaksIndexList){
                    if( peaksIndex/blockSize == ithOkBlock){ // peak in the ith block
                        ithOkBlock++; // go to check (i+1)th block
                    }
                }
                if(ithOkBlock == numBlocks){
                    return numBlocks;
                }
*
*  缺陷分析：(1) 缺乏从高到低排序的思路，可以直接优先找大的，不用Math.max
*          (2) 检查代码利用Set大大降低了check的效率
* */

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static int solution(int[] A){
        Set<Integer> peaks = new HashSet<>();
        for(int i = 1; i < A.length - 1; i++){
            if(A[i-1] < A[i] && A[i] > A[i + 1] ){
                peaks.add(i);
            }
        }
        int len = A.length;
        int n = (int)Math.sqrt(len);
        int max = 0;
        for(int i = n; i >= 2; i--){
            if(len % i == 0){  // i represent amount in one block
                if(isValid(len,peaks,i)){
                    max = Math.max(max, len/i);
                }
                if(isValid(len,peaks,len/i)){
                    max = Math.max(max, i);
                }
            }
        }
        return max;

    }
    // 0 1 2 3   4 5 6 7   8 9 10 11
    //[1,2,3,4],[3,4,1,2], [3,4,6,2]
    // n = 4
    // m = 3
    //
    private static boolean isValid(int len, Set<Integer> peaks, int n){
        int m = len / n;
        int idx = 0;

        while(idx < m){
            int cnt = 0;
            for(int i = n * idx; i <= n * idx + n - 1; i++){
                if(peaks.contains(i)){
                    cnt++;
                }
            }
            if(cnt >= 1){
                idx++;
            }else{
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] input = {1,2,3,4,3,4,1,2,3,4,6,2};
        int res = Solution.solution(input);
        System.out.println(res);
    }
}
