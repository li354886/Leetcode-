public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        int m = 0;
        int n = 0;
        int cm = 0;
        int cn = 0;
        for (int a : nums) {
            if (a == m) {
                cm++;
            }else if (a == n) {
                cn++;
            }else if (cm == 0) {
                m = a;
                cm = 1;
            } else if (cn == 0) {
                n = a;
                cn = 1;
            } else {
                cm--;
                cn--;
            }
        }
        cm = cn = 0;
        for (int a : nums) {
            if (a == m) {
                cm++;
            } else if (a == n) {
                cn++;
            }
        }
        
        if (cm > nums.length / 3) {
            result.add(m);
        } 
        if (cn > nums.length / 3) {
            result.add(n);
        }
        return result;
    }
}