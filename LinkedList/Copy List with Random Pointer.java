/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode p = head;
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode q = dummy;
        
        while (p != null) {
            q.next = new RandomListNode(p.label);
            map.put(p, q.next);
            p = p.next;
            q = q.next;
        }
        p = head;
        q = dummy;
        while (p != null) {
            q.next.random = map.get(p.random);
            p = p.next;
            q = q.next;
        }
        return dummy.next;
    }
}