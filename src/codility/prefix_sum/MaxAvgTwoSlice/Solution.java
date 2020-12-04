package codility.prefix_sum.MaxAvgTwoSlice;

public class Solution {
    public int solution(int[] A){

        int[] prefix = new int[A.length + 1];
        float min = Float.MAX_VALUE;
        int res = 0;
        for(int i = 0; i < A.length; i++){
            prefix[i+1] = prefix[i] + A[i];
        }
        for(int i = 0; i < A.length-1; i++){

            int i0 = i;
            int i1 = i + 1;
            float avg2 = (prefix[i1 + 1] - prefix[i0]) / 2.0f;

            if (avg2 < min)
            {
                min = avg2;
                res = i;
            }

            if (i < A.length - 2)
            {
                int i2 = i + 2;
                float avg3 = (prefix[i2 + 1] - prefix[i0]) / 3.0f;

                if (avg3 < min)
                {
                    min = avg3;
                    res = i;
                }
            }
        }
        return res;
    }
}
