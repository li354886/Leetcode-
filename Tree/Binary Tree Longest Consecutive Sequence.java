/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int longestConsecutive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return helper(root, 1, root.val);
    }
    
    private int helper(TreeNode root, int currLen, int lastValue) {
        if (root == null) {
            return currLen;
        }
        if (root.val == lastValue + 1) {
            currLen++;
        }else {
            currLen = 1;
        }
        int left = helper(root.left, currLen, root.val);
        int right = helper(root.right, currLen, root.val);
        return Math.max(Math.max(left, right), currLen);
    }
}