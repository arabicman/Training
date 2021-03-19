package leetcode.algorithm.Q143_ReorderList;

import leetcode.algorithm.ListNode;

public class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null){
            return;
        }
        //Step1 Find Middle and Divide LL to 2 parts
        ListNode mid = getMiddle(head);
        ListNode l1 = head;
        ListNode l2 = mid.next;
        mid.next = null; // delink

        //Step2 Reverse part 2
        ListNode l3 = reverse(l2);
        //Step3 Merge 2 parts
        merge(l1, l3);
    }

    private ListNode getMiddle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverse(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode prev = null;
        while(head != null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    private ListNode merge(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(l1 != null && l2 != null){
            cur.next = l1;
            l1 = l1.next;
            cur.next.next = l2;
            l2 = l2.next;
            cur = cur.next.next;
        }
        if(l1 != null){
            cur.next = l1;
        }else{
            cur.next = l2;
        }
        return dummy.next;
    }
}
