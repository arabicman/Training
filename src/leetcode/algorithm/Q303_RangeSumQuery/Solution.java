package leetcode.algorithm.Q303_RangeSumQuery;

class NumArray {
    private int[] prefix;

    public NumArray(int[] nums) {
        prefix = new int[nums.length];
        prefix[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            prefix[i] = prefix[i-1] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        if(right == 0){
            return prefix[0];
        }
        if(left == 0){
            return prefix[right];
        }
        return  prefix[right] - prefix[left - 1];
    }
}
//[-2, 0, 3, -5, 2, -1]
// -2 -2  1  -4, -2, -3