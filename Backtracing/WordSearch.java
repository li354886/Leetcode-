public class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || word == null 
        || board.length == 0 || board[0].length == 0) {
            return false;
        }
        
        int rows = board.length;
        int cols = board[0].length;
        
        boolean[][] visit = new boolean[rows][cols];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (adj(board, i, j, word, 0, visit)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean adj(char[][]board, int i, int j, String word, int wordIndex, boolean[][] visit){
        int rows = board.length;
        int cols = board[0].length;
        
        int len = word.length();
        if (wordIndex >= len) {
            return true;
        }
        
        if (i < 0 || i >= rows || j < 0 || j >= cols) {
            return false;
        }
        
        if (word.charAt(wordIndex) != board[i][j]) {
            return false;
        }
        
        if (visit[i][j] == true) {
            return false;
        }
        
        visit[i][j] = true;
        
        if (adj(board, i - 1, j, word, wordIndex + 1, visit)) {
            return true;
        }
        
        if (adj(board, i + 1, j, word, wordIndex + 1, visit)) {
            return true;
        }
        
        if (adj(board, i, j + 1, word, wordIndex + 1, visit)) {
            return true;
        }
        
        if (adj(board, i, j - 1, word, wordIndex + 1, visit)) {
            return true;
        }
        
        visit[i][j] = false; // This is to backtrace
        return false;
    }
}