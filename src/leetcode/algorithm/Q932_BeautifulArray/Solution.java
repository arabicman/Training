package leetcode.algorithm.Q932_BeautifulArray;

public class Solution {
    public int[] beautifulArray(int N) {
        if (N == 1){
            return new int[]{1};
        }else if (N == 2){
            return new int[]{1,2};
        }
        int[] res = new int[N];
        int[] odds = beautifulArray((N + 1) / 2);
        int[] evens = beautifulArray(N / 2);
        for (int i = 0; i < odds.length; i ++){
            res[i] = odds[i] * 2 - 1;
        }
        for (int j = 0; j < evens.length; j ++){
            res[odds.length + j] = evens[j] * 2;
        }
        return res;
    }
}
