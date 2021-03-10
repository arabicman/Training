package leetcode.algorithm.Q179_LargestNumber;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public String largestNumber(int[] nums) {
        if(nums == null || nums.length == 0){
            return "";
        }
        Integer[] arr = new Integer[nums.length];
        for(int i = 0; i < nums.length; i++){
            arr[i] = nums[i];
        }
        Arrays.sort(arr, (a, b)->{
            String sa = String.valueOf(a);
            String sb = String.valueOf(b);
            String s1 = sa + sb;
            String s2 = sb + sa;
            return Long.parseLong(s1) > Long.parseLong(s2) ? -1 : 1;
        });
        StringBuilder sb = new StringBuilder();
        for(Integer i : arr){
            if(sb.length() == 0 && i.equals(0)){
                return "0";
            }
            sb.append(String.valueOf(i));
        }
        return sb.toString();
    }
}
//                (a, b)->{
//                String as = String.valueOf(a);
//                String bs = String.valueOf(b);
//                int n = Math.max(as.length(),bs.length());
//                for(int i = 0; i < n; i++){
//                    if(as.length() <= i){
//                        return as.charAt(0) - '0' > bs.charAt(i) - '0'? -1 : 1 ;
//                    }else if(bs.length() <= i){
//                        return as.charAt(i) - '0' < bs.charAt(0) - '0'? 1 : -1 ;
//                    }
//                    int aa = as.charAt(i) - '0';
//                    int bb = bs.charAt(i) - '0';
//                    if(aa != bb){
//                        return aa > bb ? -1 : 1;
//                    }else{
//                    }
//                }
//                return  -1; }
