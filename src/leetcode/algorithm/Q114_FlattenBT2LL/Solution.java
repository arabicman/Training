package leetcode.algorithm.Q114_FlattenBT2LL;

public class Solution {
    public void flatten(TreeNode root) {
        TreeNode[]  prev = new TreeNode[1];
        helper(root, prev);
    }

    private void helper(TreeNode root, TreeNode[] prev){
        if(root == null){
            return;
        }
        helper(root.right, prev);
        helper(root.left, prev);
        root.right = prev[0];
        root.left = null;
        prev[0] = root;
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