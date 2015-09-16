public class Solution {
    public int maxProfit(int[] prices) {
        int N = prices.length;
        if (N < 2) {
            return 0;
        }
        
        int[] f = new int[N];
        int[] g = new int[N];
        
        int min = prices[0];
        for (int i = 1; i < N; i++) {
            min = Math.min(min, prices[i]);
            f[i] = Math.max(f[i - 1], prices[i] - min);
        }
        
        int max = prices[N - 1];
        for (int i = N - 2; i >= 0; i--) {
            max = Math.max(max, prices[i]);
            g[i] = Math.max(g[i + 1], max - prices[i]);
        }
    
        int profit = 0;
        for (int i = 0; i < N; i++) {
            profit = Math.max(profit, f[i] + g[i]);
        }
        return profit;
    }
}