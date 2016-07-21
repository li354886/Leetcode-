public class Solution {
    public int[][] generateMatrix(int n) {
        if (n < 0) {
            return null;
        }
        
        int[][] matrix = new int[n][n];
        int xStart = 0;
        int yStart = 0;
        int num = 1;
        
        while (n > 0) {
            if (n == 1) {
                matrix[yStart][xStart] = num++;
                break;
            }
            
            for (int i = 0; i < n - 1; i++) {
                matrix[yStart][xStart + i] = num++;
            }
            
            for (int i = 0; i < n - 1; i++) {
                matrix[yStart + i][xStart + n - 1] = num++; 
            }
            
            for (int i = 0; i < n - 1; i++) {
                matrix[yStart + n - 1][xStart + n - 1 - i] = num++;
            }
            
            for (int i = 0; i < n - 1; i++) {
                matrix[yStart + n - 1 - i][xStart] = num++;
            }
            
            xStart++;
            yStart++;
            n -= 2;
        }
        
        return matrix;
    }
}