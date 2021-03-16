package leetcode.algorithm.Q102_BinaryTreeLevelTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            List<Integer> curLayer = new ArrayList<>();
            int n = queue.size();
            while(n > 0){
                TreeNode cur = queue.poll();
                curLayer.add(cur.val);
                if(cur.left != null){
                    queue.offer(cur.left);
                }
                if(cur.right != null){
                    queue.offer(cur.right);
                }
                n--;
            }
            res.add(curLayer);
        }
        return res;
    }
}
