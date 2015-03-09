public class Solution {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0
            || matrix[0].length == 0) {
            return;
        }
        
        int n = matrix.length;
        int top = 0, down = n - 1, left = 0, right = n - 1;
        
        while (n > 1) {
            for (int i = 0; i < n - 1; i++) {
                int tmp = matrix[top][left + i];
                matrix[top][left + i] = matrix[down - i][left];  //left = top
                matrix[down - i][left] = matrix[down][right - i]; //down = left
                matrix[down][right - i] = matrix[top + i][right]; //right = down
                matrix[top + i][right] = tmp;                    //top = down
            }
            top++;
            right--;
            left++;
            down--;
            
            n -= 2;
        }
        return;
    }
}