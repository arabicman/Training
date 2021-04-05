package leetcode.algorithm.Q969_PancakeSorting;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> res = new ArrayList<>();
        for (int i = arr.length - 1 ; i > 0 ; i --) {
            int temp = getX(arr, i);
            if(temp != i){
                reverse(arr, temp);
                res.add(temp+1);
                reverse(arr, i);
                res.add(i+1);
            }
        }
        return res;
    }

    private void reverse(int[] arr, int k){
        int l = 0;
        int r = k;
        while(l < r){
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
    }

    private int getX(int[] arr, int x){
        int temp = 0;
        int maxVal = arr[0];
        for(int j = 0; j <= x; j++){
            if(arr[j] > maxVal){
                maxVal = arr[j];
                temp = j;
            }
        }
        return temp;
    }


}
