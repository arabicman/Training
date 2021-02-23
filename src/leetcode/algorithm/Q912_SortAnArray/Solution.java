package leetcode.algorithm.Q912_SortAnArray;

public class Solution {

    public int[] sortArray(int[] nums) {
        if(nums == null || nums.length <= 1){
            return nums;
        }
        int left = 0;
        int right = nums.length - 1;
        return helper(nums, left, right);

    }

    private int[] helper(int[] nums, int left, int right){
        if(left == right){
            return new int[]{nums[left]};
        }
        int mid = left + (right - left) / 2;
        int[] leftResult = helper(nums, left, mid);
        int[] rightResult = helper(nums, mid+1, right);
        return merge(leftResult,rightResult);
    }

    private int[] merge(int[] lRes, int[] rRes){
        int[] res = new int[lRes.length + rRes.length];
        int lIdx = 0;
        int rIdx = 0;
        int resIdx = 0;

        while(lIdx < lRes.length && rIdx < rRes.length){
            if(lRes[lIdx] <= rRes[rIdx]){
                res[resIdx] = lRes[lIdx];
                lIdx++;
            }else{
                res[resIdx] = rRes[rIdx];
                rIdx++;
            }
            resIdx++;
        }
        while(lIdx < lRes.length){
            res[resIdx] = lRes[lIdx];
            lIdx++;
            resIdx++;
        }

        while(rIdx < rRes.length){
            res[resIdx] = rRes[rIdx];
            rIdx++;
            resIdx++;
        }
        return res;
    }
}
