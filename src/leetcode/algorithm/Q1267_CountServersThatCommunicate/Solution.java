package leetcode.algorithm.Q1267_CountServersThatCommunicate;


import java.util.HashSet;
import java.util.Set;

public class Solution {

    public int countServers(int[][] grid) {

        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < grid.length; i++){
            int sum = 0;
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    sum ++;
                }
            }
            if(sum > 1){
                for(int j = 0; j < grid[0].length; j++){
                    if(grid[i][j] == 1){
                        set.add(grid[0].length * i + j);
                    }
                }
            }
        }
        for(int i = 0; i < grid[0].length; i++){
            int sum = 0;
            for(int j = 0; j < grid.length; j++){
                if(grid[j][i] == 1){
                    sum ++;
                }
            }
            if(sum > 1){
                for(int j = 0; j < grid.length; j++){
                    if(grid[j][i] == 1){
                        set.add(grid[0].length * j + i);
                    }
                }
            }
        }


        return set.size();
    }

//    private int getPos( int x, int y){
//        if(x < 0 || x >= grid[0].length || y < 0 || y >= grid.length){
//            return 0;
//        }
//        return grid[y][x];
//    }

}
