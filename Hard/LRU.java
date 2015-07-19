public class LRUCache {
    private int capacity;
    private Map<Integer, Node> map;
    private Node head, tail;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<Integer, Node>();
        head = null;
        tail = null;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        } else {
            moveToEnd(map.get(key));
            return map.get(key).value;
        }
    }
    
    public void set(int key, int value) {
        if (!map.containsKey(key)) {
            if (map.size() == capacity) {
                map.remove(head.key);
                remove(head);
            }
            Node node = new Node(key, value);
            map.put(key, node);
            addToEnd(node);
        } else {
            map.get(key).value = value;
            moveToEnd(map.get(key));
        }
    }
    
    private void moveToEnd(Node node) {
        if (node == tail) {
            return;
        } else {
            remove(node);
            addToEnd(node);
        }
    }
    
    private void remove(Node node) {
        if (node == head) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
        } else if (node == tail) {
            tail = tail.prev;
            tail.next = null;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }
    
    private void addToEnd(Node node) {
        if (head == null) {
            head = node;
            tail = node;
        } else {
            node.prev = tail;
            tail.next = node;
            tail = node;
        }
    }
}

class Node {
    int key;
    int value;
    Node prev;
    Node next;
    
    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}