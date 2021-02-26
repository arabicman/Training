package leetcode.algorithm.Q147_InsertionSortList;

public class Solution {
    public ListNode insertionSortList(ListNode head) {

        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode prev = dummy;
        dummy.next = head;
        while(head != null){
            ListNode next = head.next;
            if(head.val < prev.val){
                prev.next = next;
                head.next = null;
                helper(dummy, head);
                head = next;
            }else{
                prev = head;
                head = next;
            }
        }
        return dummy.next;

    }
    private void helper(ListNode dummy, ListNode target){
        if(dummy.next == target){
            return;
        }
        ListNode prev = dummy;
        ListNode cur = dummy.next;
        while(cur != null){
            if(target.val >= prev.val && target.val <= cur.val){
                prev.next = target;
                target.next = cur;
                return;
            }
            prev = cur;
            cur = cur.next;
        }
        return;
    }
}

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
