public class Solution {
    public int maxCoins(int[] nums) {
        int[] p = new int[nums.length + 2];
        System.arraycopy(nums, 0, p, 1, nums.length);
        p[0] = 1;
        p[p.length - 1] = 1;
        int n = p.length - 1;
        int[][] m = new int[n][n];
        for (int i = 0; i < n; i++)
            m[i][i] = 0;
        for (int l = 2; l <= n; l++)
            for (int i = 0; i <= n - l; i++) {
                int j = i + l - 1;
                m[i][j] = Integer.MIN_VALUE;
                for (int k = i; k < j; k++)
                    m[i][j] = Math.max(m[i][j], m[i][k] + m[k + 1][j] + p[i] * p[k + 1] * p[j + 1]);
            }
        return m[0][n - 1];
    }
}