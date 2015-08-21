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
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = 0;
        int right = 0;
        TreeNode leftNode = root;
        TreeNode rightNode = root;
        while (leftNode != null) {
            left++;
            leftNode = leftNode.left;
        }
        while (rightNode != null) {
            right++;
            rightNode = rightNode.right;
        }
        if (left == right) {
            return (2 << (left - 1)) - 1;
        } else {
            return countNodes(root.left) + countNodes(root.right) + 1;
        }
    }
}