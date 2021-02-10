package leetcode.algorithm.Q1302_DeepestLeaveSum;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public int deepestLeavesSum(TreeNode root) {
        if(root != null && root.left == null && root.right == null){
            return root.val;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        int res = 0;
        while( !deque.isEmpty()){
            int remain = deque.size();
            int curSum = 0;
            while(remain > 0){
               TreeNode cur = deque.pollFirst();
               if(cur.left != null){
                   deque.offerLast(cur.left);
               }
               if(cur.right != null){
                   deque.offerLast(cur.right);
               }
               curSum  += cur.val;
               remain--;
            }
            res = curSum;
        }
        return res;
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