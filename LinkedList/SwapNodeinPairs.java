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
    public ListNode swapPairs(ListNode head) {
        if(head == null||head.next == null){
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode pre = dummy;
        
        while(pre.next != null && pre.next.next != null ){
            ListNode next = pre.next.next.next; //store the node that is after the reverse pairs
            ListNode tmp = pre.next; 
            pre.next = pre.next.next; //Link the head with the second node in the pair
            pre.next.next = tmp; //reverse the pair
            tmp.next = next; //link the current second node with the node that is after the pair
            pre = tmp;
        }
        return dummy.next;
    }
}