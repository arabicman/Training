package leetcode.algorithm.Qxx_Test;

import org.junit.Test;

public class Solution{

    @Test
    public void test(){
        int[] arr1 = {0, 1};
        int head = 0;
        int tail = arr1.length - 1;
        while(head <= tail){
            if(head == 1 && tail == 0){
                head ++ ;
                tail --;
            }else if(arr1[head] == 0 && arr1[tail] == 1){
                swap(arr1, head++, tail--);
            }else if(arr1[head] == 1){
                head ++;
            }else if(arr1[tail] == 0){
                tail --;
            }
        }
        for (int a : arr1) {
            System.out.println(a);
        }


    }

    private void swap(int[] arr, int a, int b){
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
