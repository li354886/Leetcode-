public class Solution {
    public int minDistance(String word1, String word2) {
        int[][] result = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i <= word1.length(); i++) {
            for (int j = 0; j <= word2.length(); j++) {
                if (i == 0 || j == 0) {
                    result[i][j] = Math.max(i, j);
                } else {
                    result[i][j] = Math.min(Math.min(result[i - 1][j] + 1, result[i][j - 1] + 1), 
                                result[i - 1][j - 1] + ((word1.charAt(i - 1) != word2.charAt(j - 1)) ? 1 : 0));
                }
            }
        }
        return result[word1.length()][word2.length()];
        
    }
}