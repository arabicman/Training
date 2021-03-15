package leetcode.algorithm.Q60_PermutationSequence;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> nums = new LinkedList<>();
        for(int i = 1; i <= n; i++){
            nums.add(i);
        }
        int[] fact = new int[n];
        fact[0] = 1;
        for(int i = 1; i < n; i++){
            fact[i] = i*fact[i-1];
        }
        k = k-1;
        StringBuilder sb = new StringBuilder();
        for(int i = n; i > 0; i --){
            int pos = k / fact[i-1];
            k = k % fact[i-1];
            sb.append(nums.get(pos));
            nums.remove(pos);
        }
        return sb.toString();
    }
}
