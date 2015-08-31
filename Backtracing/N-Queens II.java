public class Solution {
    public int totalNQueens(int n) {
        return dfs(n, 0, 0, 0, 0);
    }
    
    private int dfs(int n, int curr, long row, long diagLeft, long diagRight) {
        int solution = 0;
        long validate = (1 << n) - 1;
        if (row == validate)    solution = 1;
        else {
            long cand = ~(row | diagLeft | diagRight) & validate;
            while (cand > 0) {
                long pos = cand & -cand;
                cand -= pos;
                solution += dfs(n, curr + 1, row | pos, (diagLeft | pos) << 1, (diagRight | pos) >> 1);
        }
    }
    return solution;
}
}