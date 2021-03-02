package leetcode.algorithm.Q18_4Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        int len = nums.length;

        for(int i = 0; i<len-3; i++){
            if(i>0 && nums[i] == nums[i-1])continue;
            for(int j = i+1; j<len-2; j++){
                if(j>i+1 && nums[j] == nums[j-1])continue;
                int tmp = target - nums[i] - nums[j];
                int left = j+1, right = len-1;
                while(left < right){
                    if(2*nums[left]>tmp || 2*nums[right]<tmp)break;
                    if(nums[left]+nums[right] == tmp){
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        left++;
                        right--;
                        while(left<right && nums[left]==nums[left-1])left++;
                        while(left<right && nums[right] == nums[right+1])right--;
                    }
                    else if(nums[left]+nums[right] < tmp){
                        left++;
                        while(left<right && nums[left]==nums[left-1])left++;
                    }
                    else{
                        right--;
                        while(left<right && nums[right] == nums[right+1])right--;
                    }

                }
            }
        }

        return res;
    }
}
