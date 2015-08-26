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
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) {
            return null;
        }
        int len = inorder.length;
        
        if (len < 1) {
            return null;
        }
        
        for (int i = 0; i < len; i++) {
            map.put(inorder[i], i);
        }
        return dfs(preorder, 0, 0, len - 1);
    }
    
    private TreeNode dfs(int[] preorder, int curr, int start, int end) {
        TreeNode root = new TreeNode(preorder[curr]);
        if (start < end) {
            int mid = map.get(preorder[curr]);
            if (start < mid) {
                root.left = dfs(preorder, curr + 1, start, mid - 1);
            }
            if (mid < end) {
                root.right = dfs(preorder, curr + mid - start + 1, mid + 1, end);
            }
        }
        return root;
    }
}