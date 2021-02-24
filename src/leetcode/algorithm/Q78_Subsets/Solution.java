package leetcode.algorithm.Q78_Subsets;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums == null){
            return res;
        }
        List<Integer> cur = new ArrayList<>();
        helper(res, cur, nums, 0);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> cur, int[] nums, int index){
        if(index >= nums.length){
            res.add(new ArrayList<>(cur));
            return;
        }
        helper(res, cur, nums, index+1);
        cur.add(nums[index]);
        helper(res, cur, nums, index+1);
        cur.remove(cur.size() - 1);


    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1, 2, 3};
        List<List<Integer>> list = sol.subsets(nums);
        for(List<Integer> l : list){
            System.out.print("[");
            for(Integer i : l){
                System.out.print(i + " ");
            }
            System.out.print("]");
            System.out.println();
        }
    }


}
