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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || head.next == null){
            return head;
        }
        
        if(m >= n){
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode pre = dummy;
        
        for(int i=1; i<m; i++){
            pre = pre.next;
        }
        
        ListNode reverseTail = pre.next;
        pre.next = null;
        
        ListNode cur = reverseTail;
        
        for(int i = m; i<=n; i++){
            if(i == n){
                reverseTail.next = cur.next;
            }
            
            ListNode tmp = cur.next;
            
            cur.next = pre.next;
            pre.next = cur;
            
            cur = tmp;
        }
        return dummy.next;
    }
}