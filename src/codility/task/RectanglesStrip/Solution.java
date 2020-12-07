package codility.task.RectanglesStrip;


import java.util.HashMap;



class Solution {
     public int solution(int[] A, int[] B){
         if(A.length == 0 || B.length == 0){
             return 0;
         }
         HashMap<Integer, Integer> map = new HashMap<>();
         int max = 1;
         for(int i = 0; i < A.length; i++){
             Integer a = map.get(A[i]);
             Integer b = map.get(B[i]);

             if(a == null){
                 map.put(A[i], 1);
             }else{
                 map.put(A[i], a+1);
                 max = Math.max(max, a+1);
             }

             if(B[i] != A[i] ){
                 if(b == null){
                     map.put(B[i], 1);
                 }else{
                     map.put(B[i], b+1);
                     max = Math.max(max, b+1);
                 }
             }else{

             }
         }
         return max;
     }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] a = {2, 3, 2, 3, 5};
        int[] b = {3, 4, 2, 4, 2};
        int res = sol.solution(a,b);
        System.out.println(res);
    }

}
