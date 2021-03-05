package leetcode.algorithm.Q54_SpiralMatrix;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> res = new ArrayList<>();
        helper(matrix, 0, 0, res);
        return res;

    }

    private void helper(int[][] matrix, int startX, int startY, List<Integer> res){

        int endX = matrix[0].length - 1 - startX;
        int endY = matrix.length - 1 - startY;
        if(startX > endX || startY > endY){
            return;
        }
        if(startX == endX){
            for(int j = startY; j <= endY; j++){
                res.add(matrix[j][startX]);
            }
            return;
        }
        if(startY == endY){
            for(int i = startX; i <= endX; i++){
                res.add(matrix[startY][i]);
            }
            return;
        }
        for(int i = startX; i < endX; i++){
            res.add(matrix[startY][i]);
        }
        for(int j = startY; j < endY; j++ ){
            res.add(matrix[j][endX]);
        }
        for(int i = endX; i > startX; i--){
            res.add(matrix[endY][i]);
        }
        for(int j = endY; j > startY; j--){
            res.add(matrix[j][startX]);
        }
        helper(matrix,startX+1,startY+1, res);
    }

}
