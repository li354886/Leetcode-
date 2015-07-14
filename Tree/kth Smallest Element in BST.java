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
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        inOrder(root, result);
        return result.get(k - 1);
    }
    
    void inOrder(TreeNode root, List<Integer> result) {
        if (root != null) {
            inOrder(root.left, result);
            result.add(root.val);
            inOrder(root.right, result);
        }
    }
}