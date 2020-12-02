package codility.prefix_sum.PassingCars;

public class Solution {
    public int solution(int[] A){
        if(A.length <= 1){
            return 0;
        }

        int zero = 0;
        int res = 0;
        for(int i = 0; i < A.length; i++){
            if(A[i] == 0){
                zero++;
            }else{
                res = res + A[i] * zero;
                if(res > 1000000000){
                    return -1;
                }
            }
        }
        return res;
    }
}
