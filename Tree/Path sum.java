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
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        Stack<TreeNode> stack = new Stack();
        stack.push(root);
        Stack<Integer> sub = new Stack();
        sub.push(root.val);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            int tmpsum = sub.pop();
            if (curr.left == null && curr.right == null) {
                if (tmpsum == sum) {
                    return true;
                }
            }else {
                if (curr.left != null) {
                    stack.push(curr.left);
                    sub.push(tmpsum + curr.left.val);
                }
                if (curr.right != null) {
                    stack.push(curr.right);
                    sub.push(tmpsum + curr.right.val);
                }
            }
        }
        return false;
    }
}