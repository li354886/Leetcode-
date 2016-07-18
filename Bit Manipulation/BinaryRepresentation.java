public class Solution {
    /**
     *@param n: Given a decimal number that is passed in as a string
     *@return: A string
     */
    public String binaryRepresentation(String n) {
        // write your code here
        if (n == null || n.length() == 0) {
            return n;
        }
        int intPart = Integer.parseInt(n.substring(0, n.indexOf(".")));
        double douPart = Double.parseDouble(n.substring(n.indexOf(".")));
        String intStr = "";
        String douStr = "";
        
        if (intPart == 0) {
            intStr += "0";
        }
        while (intPart > 0) {
            int c = intPart % 2;
            intStr = c + intStr;
            intPart = intPart / 2;
        }
        while (douPart > 0.0) {
            if (douStr.length() > 32) {
                return "ERROR";
            }
            double r = douPart * 2;
            if (r >= 1) {
                douStr += "1";
                douPart = r - 1.0;
            }else {
                douStr += "0";
                douPart = r;
            }
        }
        return douStr.length() > 0 ? intStr + "." + douStr : intStr;
    }
}