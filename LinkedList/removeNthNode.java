/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
         if (head == null) {
            return null;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode tail = dummy;
        
        for(int i = n; i>0; i--){
            tail = tail.next;
        }
        
        ListNode pre = dummy;
        
        while(tail != null && tail.next != null){
            tail = tail.next;
            pre = pre.next;
        }
        
        if(pre.next != null){
            pre.next = pre.next.next;
        }
        return dummy.next;
    }
}