package leetcode.algorithm.Q116_PopulatingNextRightPointers;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public Node connect(Node root) {
        //BFS
        if(root == null){
            return null;
        }
        Deque<Node> deque = new LinkedList<>();
        deque.offer(root);
        while(!deque.isEmpty()){
            int size = deque.size();
            while(size > 0){
                Node cur = deque.pollFirst();
                if(size != 1){
                    cur.next = deque.peekFirst();
                }
                if(cur.left != null){
                    deque.offerLast(cur.left);
                }
                if(cur.right != null){
                    deque.offerLast(cur.right);
                }
                size --;
            }
        }
        return root;
    }
}
