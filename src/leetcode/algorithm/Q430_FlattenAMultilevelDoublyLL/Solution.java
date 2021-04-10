package leetcode.algorithm.Q430_FlattenAMultilevelDoublyLL;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Solution {
    public Node flatten(Node head) {
        if(head == null || (head.next == null&& head.child == null)){
            return head;
        }
        List<Node> list = new ArrayList<>();
        helper(list, head);
        Node prev = list.get(0);
        prev.child = null;
        for(int i  = 1; i <= list.size()-2; i++){
            Node cur = list.get(i);
            Node next = list.get(i+1);
            prev.next = cur;
            cur.prev = prev;
            cur.next = next;
            next.prev = cur;
            cur.child = null;
            prev = cur;
            if(i == list.size()-2){
                next.next = null;
                next.child = null;
            }
        }
        return head;

    }

    private void helper(List<Node> list, Node node){
        if(node == null){
            return;
        }
        list.add(node);
        if(node.child != null){
            helper(list, node.child);
        }
        if(node.next != null){
            helper(list, node.next);
        }
    }
}

class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
}
