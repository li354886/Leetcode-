public class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] D = new int[rows][cols];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                D[i][j] = grid[i][j];
                if (i == 0 && j == 0){
                    continue;
                }else if (i == 0) {
                    D[i][j] +=  D[i][j - 1];
                }else if (j == 0) {
                    D[i][j] += D[i - 1][j];
                }else {
                    D[i][j] += Math.min(D[i - 1][j], D[i][j - 1]);
                }
            }
        }
        return D[rows - 1][cols - 1];
    }
}