/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = slow.next;
        ListNode pre = slow;
        while (fast != null) {
            ListNode tmp = fast.next;
            fast.next = pre;
            pre = fast;
            fast = tmp;
        }
        
        while (slow.next != null) {
            slow = slow.next;
            if (head.val != slow.val) {
                return false;
            }
            head = head.next;
        }
        return true;
    }
}