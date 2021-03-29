package leetcode.algorithm.Q36_ValidSodoku;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        //Step 1: Check Square
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(!checkSquare(board, i , j)){
                    return false;
                }
            }
        }
        //Step 2 : Check Row
        for(int i = 0; i < 9; i++){
            if(!checkRow(board, i)){
                return false;
            }
        }
        //Step 3 : Check Column
        for(int j = 0; j < 9; j++){
            if(!checkCol(board, j)){
                return false;
            }
        }
        return true;
    }

    private boolean checkSquare(char[][] board, int i, int j){
        Set<Character> set = new HashSet<>();
        for(int m = 0; m < 3; m++){
            for(int n = 0; n < 3; n++){
                char cur = board[i*3+m][j*3+n];
                if(cur != '.'){
                    if(set.contains(cur)){
                        return false;
                    }
                    set.add(cur);
                }
            }
        }
        return true;
    }

    private boolean checkRow(char[][] board, int row){
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < 9; i++){
            char cur = board[row][i];
            if(cur != '.'){
                if(set.contains(cur)){
                    return false;
                }
                set.add(cur);
            }
        }
        return true;
    }

    private boolean checkCol(char[][] board, int col){
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < 9; i++){
            char cur = board[i][col];
            if(cur != '.'){
                if(set.contains(cur)){
                    return false;
                }
                set.add(cur);
            }
        }
        return true;
    }

}
