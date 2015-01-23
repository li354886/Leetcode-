/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null){
            return null;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        
        ListNode cross = null;
        
        while(fast != null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
            
            if(slow == fast){
                cross = slow;
                break;
            }
            
        }
        
        if(cross == null){
            return null;
        }
        
        slow = head;
        while(true){
            if(slow == fast){
                return slow;
            }
            
            slow = slow.next;
            fast = fast.next;
        }
    }
}