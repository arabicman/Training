package leetcode.algorithm.Q1689_PartitioningIntoMininumNumberOfDeci;

public class Solution {
    public int minPartitions(String n) {
        if(n == null || n.length() < 1){
            return 0;
        }
        int max = 0;
        for(int i = 0; i < n.length(); i++){
            int cur = n.charAt(i) - '0';
            max = Math.max(max, cur);
            if(max == 9){
                return 9;
            }
        }
        return max;
    }
}
