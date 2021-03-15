package leetcode.algorithm.Q137_SingleNumberII;

public class Solution {
    public int singleNumber(int[] nums) {
        int[] digits = new int[32];
        for(int i=0; i < nums.length; i++){
            int mask = 1;
            for(int j = 31; j >= 0; j--){
                if((mask & nums[i]) != 0){
                    digits[j]++;
                }
                mask <<= 1;
            }
        }
        int res = 0;
        for(int i=0; i<32; i++){
            if(digits[i]%3 == 1){
                res += 1;
            }
            if(i == 31){
                continue;
            }
            res <<= 1;
        }
        return res;
    }
}
