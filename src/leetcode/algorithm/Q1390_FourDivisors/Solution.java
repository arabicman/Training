package leetcode.algorithm.Q1390_FourDivisors;

public class Solution {

    public int sumFourDivisors(int[] nums) {
        int res = 0;
        for(int num : nums){
            if(num % Math.sqrt(num) != 0){ // sqrt(div) should not be included
                int[] cur = divisorNums(num);
                if(cur[0] == 2){
                    res += cur[1];
                }
            }

        }
        return res;
    }

    private int[] divisorNums(int div){
        int[] res = new int[2];

        for(int i = 1; i <= Math.sqrt(div); i++){
            if(div % i == 0){
                res[0]++;
                res[1] += (i + div/i) ;
            }
            if(res[0] >= 3){
                return res;
            }
        }
        return res;
    }
}
