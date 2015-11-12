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
    private HashMap<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int len = inorder.length;
        if (len < 1) {
            return null;
        }
        for (int i = 0; i < len; i++) {
            map.put(inorder[i], i);
        }
        return helper(postorder, len - 1, 0, len - 1);
    }
    
    private TreeNode helper(int[] postorder, int curr, int start, int end) {
        TreeNode root = new TreeNode(postorder[curr]);
        if (start < end) {
            int mid = map.get(postorder[curr]);
            if (start < mid) {
                root.left = helper(postorder, curr - (end - mid) - 1, start, mid - 1);
            }
            if (mid < end) {
                root.right = helper(postorder, curr - 1, mid + 1, end); //curr - 1 is the right node of root.
            }
        }
        return root;
    }
}