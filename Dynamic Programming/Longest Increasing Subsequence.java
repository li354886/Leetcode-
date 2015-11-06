public class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        int[] maxLen = new int[]{0};
        getMaxLen(nums, 0, maxLen, new ArrayList<Integer>());
        return maxLen[0];
    }

    public void getMaxLen(int[] nums, int startPos, int[] maxLen, List<Integer> tmp)
    {
        if (startPos == nums.length)
        {
            maxLen[0] = Math.max(tmp.size(), maxLen[0]);
            return;
        }

        // if there's no enough numbers behind current position, just return
        if (tmp.size() + nums.length - startPos < maxLen[0]) return;


        int largerCnt = 0;  // a counter to counter how many numbers behind current position larger than current num
        for (int index = startPos; index < nums.length; index++)
        {
            if (tmp.size() == 0 || tmp.get(tmp.size() - 1) < nums[index])
            {
                largerCnt++;
                tmp.add(nums[index]);
                getMaxLen(nums, index + 1, maxLen, tmp);
                tmp.remove(tmp.size() - 1);
            }
        }

        // if no larger numbers behind current number, then the current number is the last one for the current sequence
        if (largerCnt == 0) maxLen[0] = Math.max(tmp.size(), maxLen[0]);
    }
}