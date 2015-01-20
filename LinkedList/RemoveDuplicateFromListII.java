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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return null;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode cur = dummy;
        
        boolean del = false;
        
        while(cur != null){
            if(cur.next != null && cur.next.next != null && cur.next.val == cur.next.next.val){
                cur.next = cur.next.next;
                del = true;
            }else{
                if(del){
                    cur.next = cur.next.next;
                    del = false;
                }else{
                    cur = cur.next;
                }
            }
        }
        return dummy.next;
    }
}