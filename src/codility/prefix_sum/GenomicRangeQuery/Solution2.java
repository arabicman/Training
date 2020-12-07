package codility.prefix_sum.GenomicRangeQuery;

public class Solution2 {
    public int[] solution(String S, int[] P, int[] Q){
        int[] arr = new int[P.length];
        for(int i = 0; i < arr.length; i++){
            String str = S.substring(P[i],Q[i]+1);
            if(str.contains("A")){
                arr[i] = 1;
            }else if(str.contains("C")){
                arr[i] = 2;
            }else if(str.contains("G")){
                arr[i] = 3;
            }else{
                arr[i] = 4;
            }
        }
        return arr;

    }
}
