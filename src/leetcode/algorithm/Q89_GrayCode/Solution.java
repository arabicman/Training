package leetcode.algorithm.Q89_GrayCode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> grayCode(int n){
        List<Integer> res = new ArrayList<>();
        res.add(0);
        for(int i = 0; i < n; i++){
            int cur = (int)Math.pow(2, i);
            for(int j = res.size() - 1; j >= 0; j--){
                // i = 0, size = 1 :
                // {0, 1}
                // i = 1, size = 2 :
                // {0, 1, 3, 2 }
                // i = 2, size = 4 :
                //{0, 1, 3, 2, 6, 7, 5, 4}
                res.add(res.get(j) + cur);
            }
        }
        return res;
    }

}
