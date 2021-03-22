package leetcode.algorithm.Q1669_MergeInBetweenLL;

import leetcode.algorithm.ListNode;

public class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        //get Node[a-1] and Node[b+1] in List1;
        int i = 0;
        ListNode cur = list1;
        while(i < a - 1){
            cur = cur.next;
            i++;
        }
        // i at position a-1
        ListNode prev = cur;
        while(i < b){
            cur = cur.next;
            i++;
        }
        // i at position b
        ListNode bb = cur;
        //get Node[tail] in List2;
        cur = list2;
        while(cur != null && cur.next != null){
            cur = cur.next;
        }
        ListNode tail = cur;
        //merge
        prev.next = list2;
        tail.next = bb.next;
        bb.next = null;
        return list1;

    }
}
