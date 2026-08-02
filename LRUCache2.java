import java.util.HashMap;
import java.util.Map;

public class LRUCache2 {
    public LRUCache2(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();

        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;
    }

    static class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private final Map<Integer, Node> cache;

    private final Node head;
    private final Node tail;


    // 3->2->1
// -----------------------------
// GET
// -----------------------------
    public int get(int key) {
//        if get(1), make it 1->3->2
        if (!cache.containsKey(key)) {
            return -1;
        }
        Node node = cache.get(key);
        // Since this was accessed, move it to the front
        remove(node);
        insertAtFront(node);

        return node.value;
    }
    // -----------------------------
    // PUT
    // -----------------------------

    public void put(int key, int value) {

        // key already exist, update its positioning
        if (cache.containsKey(key)) {
            Node existingNode = cache.get(key);
            existingNode.value = value;
            remove(existingNode);
            insertAtFront(existingNode);
            return;
        }

        // otherwise if this is new element totally
        Node newNode = new Node(key, value);
        cache.put(key, newNode);

        insertAtFront(newNode);

        // if the Cache capacity is FULL, remove the least recently used element
        if (cache.size() > capacity) {
            Node leastRecentlyUsed = tail.prev;
            remove(leastRecentlyUsed);
            cache.remove(leastRecentlyUsed.key);
        }
    }

    // -----------------------------
    // Remove a node from Doubly Linked List
    // -----------------------------
    private void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    // -----------------------------
    // Insert node immediately after head
    // -----------------------------
    private void insertAtFront(Node node) {
        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }

    // -----------------------------
    // Helper method for debugging
    // -----------------------------
    public void printCache(){
        Node curr= head.next;
        System.out.println("Cache: ");
        while (curr!=tail){
            System.out.println("("+curr.key+", "+curr.value+") ");
            curr=curr.next;
        }
        System.out.println();
    }

    // main method
    public static void main(String[] args) {
        LRUCache2 cache = new LRUCache2(2);
        cache.put(1,10);
        cache.printCache();

        cache.put(2,20);
        cache.printCache();

        System.out.println(cache.get(1));
        cache.printCache();

        cache.put(3,30);
        cache.printCache();

        System.out.println(cache.get(2));
        cache.put(4,40);
        cache.printCache();

        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));

        cache.printCache();
    }
}
