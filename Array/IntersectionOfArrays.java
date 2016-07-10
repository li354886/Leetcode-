public class Solution {
    /**
     * @param nums1 an integer array
     * @param nums2 an integer array
     * @return an integer array
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        // Write your code here
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] tmp = new int[nums1.length];
        int i = 0;
        int j = 0;
        
        int index = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                if (index == 0 || tmp[index - 1] != nums1[i]) {
                    tmp[index++] = nums1[i];
                }
                i++;
                j++;
            }else if (nums1[i] < nums2[j]) {
                i++;
            }else {
                j++;
            }
        }
        int[] result = new int[index];
        for (int k = 0; k < index; k++) {
            result[k] = tmp[k];
        }
        return result;
    }
}