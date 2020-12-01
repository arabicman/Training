package codility.caterpillar.countTriangle;

import java.util.Arrays;

public class Solution {
    public int solution(int[] A) {
        int cnt = 0;
        Arrays.sort(A);

        for (int i = 0; i < A.length - 2; i++) {
            int leftEnd = i + 1;
            int rightEnd = i + 2;
            //fixed i, fixed leftEnd, shifted rightEnd.
            while(leftEnd < A.length - 1){
                if(rightEnd < A.length && A[i] + A[leftEnd] > A[rightEnd]){
                    rightEnd++;
                }else{
                    cnt = cnt + (rightEnd - leftEnd - 1);
                    leftEnd++;
                }
            }
        }
        return cnt;
    }


}
