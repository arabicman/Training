package leetcode.algorithm.Q79_WordSearch;

public class Solution {
    static boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        char[] w = word.toCharArray();
        visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (backtrack(board, i, j, w, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, int row, int col, char[] w, int index) {
        if (index == w.length) {
            return true;
        }
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || visited[row][col]) {
            return false;
        }
        if (w[index] != board[row][col]) {
            return false;
        }

        visited[row][col] = true;

        if (backtrack(board, row + 1, col, w, index+1)
                || backtrack(board, row - 1, col, w, index+1)
                || backtrack(board, row, col + 1, w, index+1)
                || backtrack(board, row, col - 1, w, index+1)) {
            return true;
        }

        visited[row][col] = false;
        return false;
    }
    // A B C E
    // S F E S
    // A D E E
    //"ABCESEEEFS"

}
