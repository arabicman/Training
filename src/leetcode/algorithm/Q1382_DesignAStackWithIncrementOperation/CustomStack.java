package leetcode.algorithm.Q1382_DesignAStackWithIncrementOperation;

import java.util.Iterator;
import java.util.LinkedList;

public class CustomStack {

    private LinkedList<Integer> stack;
    private int maxSize;

    public CustomStack(int maxSize) {
        this.stack = new LinkedList<Integer>();
        this.maxSize = maxSize;
    }

    public void push(int x) {
        if(stack.size() >= maxSize){
            return;
        }
        stack.offerFirst(x);

    }

    public int pop() {
        if(stack.isEmpty() || stack.peekFirst()==null){
            return -1;
        }
        return stack.pollFirst();
    }

    public void increment(int k, int val) {
        if(stack.isEmpty()){
            return;
        }
        int n = Math.min(k, stack.size());
        LinkedList<Integer> temp = new LinkedList<>();
        while(!stack.isEmpty()){
            temp.offerFirst(stack.pollFirst());
        }
        while (n > 0) {
            stack.offerFirst(temp.pollFirst() + val);
            n--;
        }
        while(!temp.isEmpty()){
            stack.offerFirst(temp.pollFirst());
        }
    }

}
