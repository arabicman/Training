package leetcode.algorithm.Q96_UniqueBST;

public class Solution {
    public int numTrees(int n) {
        if(n == 1){
            return 1;
        }
        int[] arr = new int[n+1];
        arr[1] = 1;
        arr[2] = 2;
        for(int i = 3; i <= n; i++){
            int total = 0;
            for(int j = 1; j<=i; j++){
                int left = (j - 1) == 0 ? 1 : j-1;
                int right = (i - j) == 0 ? 1 : i-j;
                int cur = arr[left] * arr[right];
                total += cur;
            }
            arr[i] = total;
        }
        return arr[n];


    }
}
