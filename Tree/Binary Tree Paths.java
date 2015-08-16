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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<String>();
        if (root == null) {
            return result;
        }
        String tmp = "" + root.val;
        dfs(result, root, tmp);
        return result;
    }
    private void dfs(List<String> result, TreeNode root, String tmp) {
        if (root.left == null && root.right == null) {
            result.add(tmp);
            return;
        }else {
            if (root.left != null) dfs(result, root.left, tmp + "->" + root.left.val); 
            if (root.right != null) dfs(result, root.right, tmp + "->" + root.right.val); 
        }
    }
}