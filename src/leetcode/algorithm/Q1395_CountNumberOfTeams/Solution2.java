//package leetcode.algorithm.Q1395_CountNumberOfTeams;
//
//import java.util.Arrays;
//
////Wrong Solution
//public class Solution2 {
//    public int numTeams(int[] rating) {
//        int asc = permutation(longestAsc(rating));
//        reverse(rating);
//        int desc =permutation(longestAsc(rating)) ;
//        return asc + desc;
//
//
//
//    }
//    private int permutation(int num){
//        if(num < 3){
//            return 0;
//        }
//        if(num == 3){
//            return 1;
//        }
//        int res = 1;
//        for(int i = num; i >= num - 2; i--){
//            res *= i;
//        }
//        return res/6;
//
//    }
//
//
//    private int longestAsc(int[] arr){
//        int[] dp = new int[arr.length];
//        dp[0] = 1;
//        int res = 1;
//        for(int i = 1; i < arr.length; i++){
//            int max = 1;
//            for(int j = 0; j < i; j++){
//                if(arr[i] > arr[j]){
//                    max = Math.max(max, dp[j]+1);
//                }
//            }
//            dp[i] = max;
//            res = Math.max(max, res);
//        }
//        return res;
//    }
//    private void reverse(int[] arr){
//        int l = 0;
//        int r = arr.length - 1;
//        while(l < r){
//            int tmp = arr[l];
//            arr[l] = arr[r];
//            arr[r] = tmp;
//            l++;
//            r--;
//        }
//    }
//
//    public static void main(String[] args) {
//        Solution sol = new Solution();
//        int[] arr = {2,5,3,4,1};
//        int res = sol.longestAsc(arr);
//        System.out.println(res);
//        sol.reverse(arr);
//        System.out.println(Arrays.toString(arr));
//        int res1 = sol.longestAsc(arr);
//        System.out.println(res1);
//        int res2 = sol.permutation(6);
//        System.out.println(res2);
//        int res3 = sol.numTeams(arr);
//        System.out.println(res3);
//    }
//}
