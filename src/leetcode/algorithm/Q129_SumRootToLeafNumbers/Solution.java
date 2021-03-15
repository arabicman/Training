package leetcode.algorithm.Q129_SumRootToLeafNumbers;



import java.util.ArrayList;
import java.util.List;

public class Solution {

    public int sumNumbers(TreeNode root) {
        if(root == null){
            return -1;
        }

        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        helper(root, sb, list);
        int sum = 0;
        for(String str : list){
            sum += Integer.parseInt(str);
        }
        return sum;


    }

    private void helper(TreeNode root, StringBuilder sb, List<String> list){
        sb.append(root.val);
        if(root.left == null && root.right == null){
            list.add(sb.toString());
            return;
        }
        if(root.left != null){
            helper(root.left, sb, list);
            sb.deleteCharAt(sb.length()-1);
        }
        if(root.right != null){
            helper(root.right, sb, list);
            sb.deleteCharAt(sb.length()-1);
        }
        return;

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
