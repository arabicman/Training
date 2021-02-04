package leetcode.algorithm.Q113_PathSumII;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();
        dfs(root, path, targetSum, res);
        return res;
    }

    private void dfs(TreeNode root, List<Integer> path, int target, List<List<Integer>> res){
        if(root != null && root.left == null && root.right == null && target - root.val == 0){
            path.add(root.val);
            res.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
            return;
        }
        if(root == null){
            return;
        }
        path.add(root.val);
        dfs(root.left, path, target - root.val, res);
        path.remove(path.size() - 1);
        path.add(root.val);
        dfs(root.right, path, target - root.val, res);
        path.remove(path.size() - 1);

    }
}
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
