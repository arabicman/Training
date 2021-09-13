package leetcode.daily.June2021;

import java.util.ArrayDeque;

public class MaxConsecutiveOnes {
    public int longestOnes(int[] nums, int k){
        ArrayDeque<Integer> zeros = new ArrayDeque<>();
        int curLen = 0, maxLen = 0;
        int head = 0, pt = 0;
        while(pt < nums.length){
            if(nums[pt] == 1){
                curLen = pt - head + 1;
                maxLen = Math.max(curLen, maxLen);
                pt ++;
            } else {
                if(k > 0){
                    k --;
                    zeros.offerLast(pt);
                    curLen = pt - head + 1;
                    maxLen = Math.max(curLen, maxLen);
                    pt ++;
                }else{
                    if(zeros.isEmpty()){
                        head = pt;
                        pt++;
                    }else{
                        head = zeros.pollFirst() + 1;
                        k ++;
                    }
                    }
                }

        }
        return maxLen;
    }
}
