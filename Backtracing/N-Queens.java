public class Solution {
    public List<List<String>> solveNQueens(int n) {
        ArrayList<List<String>> result = new ArrayList<List<String>>();
        dfs(n, 0, new int[n], result);
        return result;
    }
    private void dfs(int n, int row, int[] columnForRow, ArrayList<List<String>> result){
        if (row == n) {
            List<String> item = new ArrayList<String>();
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (columnForRow[i] == j) {
                        sb.append('Q');
                    } else {
                        sb.append('.');
                    }
                }
                item.add(sb.toString());
            }
            result.add(item);
            return;
        }
        for (int i = 0; i < n; i++) {
            columnForRow[row] = i;
            if (check(row, columnForRow)) {
                dfs(n, row + 1, columnForRow, result);
            }
        }
    }
    
    private boolean check(int row, int[] columnForRow) {
        for (int i = 0; i < row; i++) {
            if (columnForRow[row] == columnForRow[i] || Math.abs(columnForRow[row] - columnForRow[i]) == row - i) {
                return false;
            }
        }
        return true;
    }
}