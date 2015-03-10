public class Solution {
    public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null) {
            return null;
        }
        
        int len1 = num1.length();
        int len2 = num2.length();
        
        int[] product = new int[len1 + len2];
        
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                product[i + j] += (num1.charAt(len1 - 1 - i) - '0') * (num2.charAt(len2 - 1 - j) - '0'); //here should be += because we should not overlap the item after j goes on.
            }
        }
        
        StringBuilder ret = new StringBuilder();
        
        int carry = 0;
        for (int i = 0; i < len1 + len2; i++) {
            product[i] = product[i] + carry;
            carry = product[i] / 10;
            product[i] %= 10;
        }
        
        for (int i = 0; i < len1 + len2; i++) {
            ret.insert(0, product[i]);
        }
        
        while (ret.length() > 1 && ret.charAt(0) == '0') {
            ret.deleteCharAt(0);
        }
        
        return ret.toString();
    }
}