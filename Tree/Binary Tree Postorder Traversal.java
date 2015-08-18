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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stackBack = new Stack<>();
        Stack<Integer> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null) {
            stack.push(curr.val);
            stackBack.push(curr);
            curr = curr.left;
        }
        while (!stackBack.isEmpty()) {
            curr = stackBack.pop();
            curr = curr.right;
            while (curr != null) {
                stack.push(curr.val);
                stackBack.push(curr);
                curr = curr.left;
            }
        }
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
        return result;
    }
}