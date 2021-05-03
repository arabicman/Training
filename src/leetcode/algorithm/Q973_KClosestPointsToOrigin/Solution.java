package leetcode.algorithm.Q973_KClosestPointsToOrigin;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Solution {
    public int[][] kClosest(int[][] points, int k) {
        List<int[]> list = new ArrayList<>();
        Stream.of(points)
                .sorted((a,b)->Integer.compare(a[0]*a[0] + a[1]*a[1], b[0]*b[0] + b[1]*b[1]))
                .limit((int)k).forEach(e->{
            //System.out.println(e[0] +"," + e[1]);
                    list.add(e);
        });
        int[][] res = new int[k][2];
        for(int i = 0; i < res.length; i++){
            res[i][0] = list.get(i)[0];
            res[i][1] = list.get(i)[1];
        }
        return res;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] points = {{3,3},{5,-1},{-2,4}};
        int k = 2;
        sol.kClosest(points, k);

    }
}
