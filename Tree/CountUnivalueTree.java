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
    public int countUnivalSubtrees(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return countUnivalSubtrees(root.left) + countUnivalSubtrees(root.right) + (unival(root, root.val) ? 1 : 0);
    }
    
    private boolean unival(TreeNode root, int val) {
        if (root == null) {
            return true;
        }
        return unival(root.left, val) && unival(root.right, val) && root.val == val;
    }
}