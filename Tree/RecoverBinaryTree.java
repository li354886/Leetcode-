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
    private Queue<TreeNode> queue = new LinkedList<>();
    public void recoverTree(TreeNode root) {
        inOrder(root);
        
        TreeNode first = null;
        TreeNode second = null;
        if (!queue.isEmpty()) {
            TreeNode prev = queue.poll();
            while (!queue.isEmpty()) {
                TreeNode curr = queue.poll();
                if (prev.val > curr.val) {
                    if (first == null) {
                        first = prev;
                        second = curr;
                    } else {
                        second = curr;
                        break;
                    }
                }
                prev = curr;
            }
        }
        swap(first, second);
    }
    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            inOrder(root.left);
        }
        queue.add(root);
        if (root.right != null) {
            inOrder(root.right);
        }
    }
    
    private void swap(TreeNode first, TreeNode second) {
        if (first == null || second == null) {
            return;
        }
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }
}