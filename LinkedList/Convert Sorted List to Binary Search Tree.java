/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
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
    private ListNode list;
    public TreeNode sortedListToBST(ListNode head) {
        int n = 0;
        ListNode p = head;
        while (p != null) {
            n++;
            p = p.next;
        }
        list = head;
        return sorted(0, n - 1);
    }
    private TreeNode sorted(int start, int end) {
        if (start > end) {
            return null;
        }
        // int mid = start + (end - start) / 2;
        // TreeNode left = sorted(0, mid - 1);
        // TreeNode parent = new TreeNode(list.val);
        // parent.left = left;
        // list = list.next;
        // TreeNode right = sorted(mid + 1, end);
        // parent.right = right;
        // return parent;
        int mid = start + (end - start) / 2;
        TreeNode left = sorted(start, mid - 1);
        TreeNode parent = new TreeNode(list.val);
        parent.left = left;
        list = list.next;
        TreeNode right = sorted(mid + 1, end);
        parent.right = right;
        return parent;
    }
}