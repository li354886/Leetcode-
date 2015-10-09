public class Solution {
    public int hIndex(int[] citations) {
         Arrays.sort(citations);
        int maxCit = 0;
        for (int i=0;i<citations.length;i++){
            int cit = Math.min(citations[i], citations.length-i);
            if (cit >= maxCit ){
                maxCit = cit;
                continue;
            }
            break;
        }
        return maxCit;
    }
}