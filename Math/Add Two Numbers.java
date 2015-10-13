/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head = new ListNode(0);
        ListNode p = head;
        int carry = 0;
        while (l1 != null && l2 != null) {
            int sum = carry + l1.val + l2.val;
            p.next = new ListNode(sum % 10);
            carry = sum / 10;
            l1 = l1.next;
            l2 = l2.next;
            p = p.next;
        }
        
        while (l1 != null) {
            int sum = carry + l1.val;
            carry = sum / 10;
            p.next = new ListNode(sum % 10);
            l1 = l1.next;
            p = p.next;
        }
        
        while (l2 != null) {
            int sum = carry + l2.val;
            carry = sum / 10;
            p.next = new ListNode(sum % 10);
            l2 = l2.next;
            p = p.next;
        }
        
        if (carry != 0) {
            p.next = new ListNode(carry);
        }
        return head.next;
    }
}