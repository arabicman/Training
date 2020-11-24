package codility.prime_and_composite.Peaks;

import java.util.*;

public class Solution2 {
    public static int solution(int[] A){

        List<Integer> peaksIndexList = new ArrayList<>();

        // 1) find the peaks (and store them)
        for(int i=1; i<A.length-1; i++){
            if( A[i-1]<A[i] && A[i]>A[i+1] ){ // A[i] > A[i-1], A[i] > A[i+1]
                peaksIndexList.add(i);
            }
        }
        // 2) check the number of Blocks
        int N = A.length;
        for(int numBlocks =N; numBlocks >=1; numBlocks--){
            if( N % numBlocks ==0){ // it is divisible
                int blockSize = N / numBlocks;
                int ithOkBlock =0;  // the ith block has peak(s)
                // test all the peaks
                for(int peaksIndex : peaksIndexList){
                    if( peaksIndex/blockSize == ithOkBlock){ // peak in the ith block
                        ithOkBlock++; // go to check (i+1)th block
                    }
                }
                if(ithOkBlock == numBlocks){
                    return numBlocks;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] input = {1,2,3,4,3,4,1,2,3,4,6,2};
        int res = Solution.solution(input);
        System.out.println(res);
    }
}
