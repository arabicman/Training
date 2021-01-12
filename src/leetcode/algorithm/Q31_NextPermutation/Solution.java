package leetcode.algorithm.Q31_NextPermutation;

public class Solution {
    public void nextPermutation(int[] nums) {
        if(nums.length == 1){
            return;
        }else if(nums.length == 2){
            swap(nums,0,1);
            return;
        }else{
            int end = nums.length - 2;
            while(end >= 0 && nums[end] >= nums[end + 1]){
                end--;
            }
            reverse(nums, end + 1, nums.length - 1);
            if(end == -1) return;
            int newInd = end+1;
            while(newInd < nums.length && nums[newInd] <= nums[end]){
                newInd++;
            }
            swap(nums, end, newInd);
        }

    }
    private void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    private void reverse(int[] nums, int i, int j){
        while(i < j){
            swap(nums, i, j);
            i++;
            j--;
        }
    }

}
