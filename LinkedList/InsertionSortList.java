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
    public ListNode insertionSortList(ListNode head) {
        if(head == null){
            return null;
        }
        
        ListNode dummy = new ListNode(0);
        
        ListNode pre = dummy;
        
        while(head!=null){
            pre = dummy;
            
            while(pre.next!=null && pre.next.val <= head.val){
                pre = pre.next;
            }
            
            ListNode tmp = head.next;
            
            head.next = pre.next;
            pre.next = head;
            
            head = tmp;
        }
        return dummy.next;
    }
}