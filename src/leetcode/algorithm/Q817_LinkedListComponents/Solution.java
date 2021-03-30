package leetcode.algorithm.Q817_LinkedListComponents;

import leetcode.algorithm.ListNode;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int numComponents(ListNode head, int[] G) {
        //corner case
        if(head == null || G == null){
            return 0;
        }
       Set<Integer> set = new HashSet<>();
        for(int num: G) set.add(num);

        int cnt = 0;
        boolean flag = false;
        while(head != null){
            if(set.contains(head.val)){
                if(!flag){
                    cnt++;
                    flag = true;
                }
            }else{
                flag = false;
            }
            head = head.next;
        }
        return cnt;
    }
}
