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
    public ListNode mergeKLists(List<ListNode> lists) {
        if(lists == null || lists.size() == 0){
            return null;
        }
        
        Comparator<ListNode> comparator = new Comparator<ListNode>(){
          public int compare(ListNode o1, ListNode o2){
              return o1.val - o2.val;
          }  
        };
        
        PriorityQueue<ListNode> q = new PriorityQueue<ListNode>(lists.size(), comparator);
        
        for(ListNode node: lists){
            if(node != null){
                q.offer(node);
            }
        }
        
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        
        while(!q.isEmpty()){
            ListNode node = q.poll();
            
            tail.next = node;
            tail = tail.next;
            
            if(node.next != null){
                q.offer(node.next);
            }
        }
        return dummy.next;
    }
}