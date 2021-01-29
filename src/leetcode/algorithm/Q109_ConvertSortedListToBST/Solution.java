package leetcode.algorithm.Q109_ConvertSortedListToBST;

public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        //step1: find the middle node
        //step2: recursion left list and right list
        //step3: connect mid, left and right
        if(head == null){
            return null;
        }
        if( head.next == null) {
            return new TreeNode(head.val);
        }
        ListNode left = head;
        ListNode mid = head;
        ListNode prev = mid;
        int len = 0;
        int mii = 0;
        ListNode right = head;

        while(head.next != null && head.next.next != null){
            head = head.next.next;
            len += 2;
            prev = mid;
            mid = mid.next;
            mii ++;
        }
        if(mii == (len-1)/2){
            prev = mid;
            mid = mid.next;
            prev.next = null;
            right = mid.next;
            mid.next = null;
        }else{
            prev.next = null;
            right = mid.next;
            mid.next = null;
        }
        TreeNode m = new TreeNode(mid.val);
        m.left = sortedListToBST(left);
        m.right = sortedListToBST(right);
        return m;
    }
}






  class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
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
