package leetcode.algorithm.Q77_Combinations;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> cur = new ArrayList<>();
        if(n < k){
            return res;
        }
        helper(res, cur, 1, n, k);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> cur, int index, int n, int k){

        if(k <= 0){
            res.add(new ArrayList<Integer>(cur));
            return;
        }
        if(index > n){
            return;
        }
        for(int i = index; i <= n; i++){
            cur.add(i);
            helper(res, cur, i+1, n, k-1);
            cur.remove(cur.size() -1);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        List<List<Integer>> res = sol.combine(4, 2);
        for(List<Integer> list : res){
            System.out.println(list.toString());
        }

    }
}
