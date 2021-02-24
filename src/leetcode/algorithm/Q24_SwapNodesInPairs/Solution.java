package leetcode.algorithm.Q24_SwapNodesInPairs;

public class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur = head;
        ListNode prev = dummy;
        while(cur != null && cur.next != null){
            ListNode next = cur.next.next;
            if(cur.next != null){
                prev.next = cur.next;
                prev.next.next = cur;
                cur.next = next;
            }
            prev = cur;
            cur = next;

        }
        return dummy.next;
    }
}

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }