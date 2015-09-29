public class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickSort(nums, 0, nums.length - 1, k);
    }
    
    private int quickSort(int[] nums, int start, int end, int k) {
        int pivot = end;
        int l = start;
        int r = end - 1;
        while (l <= r) {
            if (nums[l] > nums[pivot]) {
                swap(nums, l, r);
                r--;
            }else {
                l++;   
            }
        }
        swap(nums, l, pivot); 
        int rank = nums.length - l;
        if (rank == k) return nums[l];
        if (rank > k) {
            return quickSort(nums, l + 1, end, k);
        } else {
            return quickSort(nums, start, l - 1, k);
        }
    }
    
    private void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }

}