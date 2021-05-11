package leetcode.algorithm.Q41_FirstMissingPositive;




public class Solution {
    public int firstMissingPositive(int[] nums) {
        int i = 0;
         while (i < nums.length){
             // eg. nums[0] = 3 && nums[2] = 5, swap to make nums[nums[i] - 1] correct
             // finally all the array will be sorted.
             if (nums[i] >= 1 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1])
                 swap(nums, i, nums[i] - 1);
             else i++;
         }
         i = 0;
         while (i < nums.length && nums[i] == i + 1) i++;
         return i + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
