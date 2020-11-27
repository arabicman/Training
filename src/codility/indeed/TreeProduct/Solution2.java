package codility.indeed.TreeProduct;

import java.util.*;

public class Solution2 {
    public static String solution(int[] A, int[] B) {
        if(A.length==1) return String.valueOf(2);

        boolean exeption = false;
        long a_b_search, b_b_search;
        int i = 0, temp, result = 0, node = 0, gard_post = 0;
        List<Integer> list = new ArrayList<>();

        for (int aA : A) {
            i++;
            a_b_search = Arrays.binarySearch(B, aA);
            if (i > 1 && a_b_search < 0) {
                temp = B[i - 1];
                B[i - 1] = A[i - 1];
                A[i - 1] = temp;
            }
        }
        A[0] = 1;
        B[0] = 0;
//        System.out.println(Arrays.toString(A));
//        System.out.println(Arrays.toString(B));

        for (int k = 1; k < B.length; k++) {
            b_b_search = Arrays.binarySearch(A, B[k]);
//            System.out.println("b_b_search:" + b_b_search);
            node++;
            if (b_b_search > 0 && A[k] != B[k - 1]) {
                gard_post++;
            }
            if (A[k] != A[k - 1]) {
                list.add(node);
                node = 0;
            }

            if (k == B.length - 1) list.add(node + 2);
            System.out.println("gard_post:" + gard_post);
        }

        if(gard_post == 0){
            result = node+2;
        }else if(gard_post==1){
            result = list.get(0)*list.get(1);
        }else{
            result = list.get(0)*list.get(1)*list.get(2);
        }

        //System.out.println("list:" + list);
        return String.valueOf(result);
    }
}
