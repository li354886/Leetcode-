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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        boolean oddLevel = false;
        stack.push(root);
        while (!stack.isEmpty()) {
            List<Integer> level = new ArrayList<Integer>();
            Stack<TreeNode> tmp = new Stack<>();
            while (!stack.isEmpty()) {
                TreeNode curr = stack.pop();
                level.add(curr.val);
                if (oddLevel) {
                    if (curr.right != null)  tmp.push(curr.right);
                    if (curr.left != null) tmp.push(curr.left);
                } else {
                    if (curr.left != null) tmp.push(curr.left);
                    if (curr.right != null) tmp.push(curr.right);
                }
            }
            result.add(level);
            stack = tmp;
            oddLevel = !oddLevel;
        }
        return result;
    }
}