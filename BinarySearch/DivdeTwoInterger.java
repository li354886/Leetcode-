public class Solution {
    public int divide(int dividend, int divisor) {
        boolean negative = (dividend > 0 && divisor < 0)||
            (divident < 0 && divisor > 0);
            
        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);
        int ans = 0;
        
        while(a >= b){
            int shift = 0;
            while((b<<shift) <= a){
                shift++;
            }
            ans += 1<<(shift - 1);
            a = a - (b<<(shift - 1));
        }
        return negative? -ans:ans;
    }
}