package leetcode.algorithm.Q162_FindPeakElement;

public class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0, high = nums.length - 1, mid = 0;
        if(nums.length == 1){
            return 0;
        }
        while(low <= high){
            mid = low + (high - low) / 2;
            if(mid == 0){
                if(nums[mid] > nums[mid + 1])
                    return mid;
                else
                    low = mid + 1;

            } else if(mid == nums.length - 1){
                if(nums[mid] > nums[mid - 1])
                    return mid;
                else
                    high = mid - 1;

            } else if(nums[mid] > nums[mid - 1] && nums[mid] > nums[ mid+1 ]){
                return mid;
            } else if(nums[mid] > nums[mid - 1]){
                low = mid + 1;
            } else{
                high = mid - 1;
            }
        }
        return -1;
    }
    // [1 6 5] 4 [5 4 5]
}
