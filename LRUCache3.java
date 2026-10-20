import java.util.HashMap;
import java.util.Map;

public class LRUCache3 {

    static class Node1 { // 4 elements key,value -- prev, next -- since its a doubly LL
        int key;
        int value;
        Node1 prev;
        Node1 next;

        Node1(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private final Map<Integer, Node1> cache;
    private final Node1 head;
    private final Node1 tail;

    public LRUCache3(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();

        head = new Node1(0, 0);
        tail = new Node1(0, 0);

        head.next = tail;
        tail.prev = head;
    }


    // 3->2->1
// -----------------------------
// GET
// -----------------------------
    public int get(int key) {
//        if get(1), make it 1->3->2
        if (!cache.containsKey(key)) {
            return -1;
        }
        Node1 node1 = cache.get(key);
        // Since this was accessed, move it to the front
        remove(node1);
        insertAtFront(node1);

        return node1.value;
    }

    // -----------------------------
    // Insert node immediately after head
    // -----------------------------
    private void insertAtFront(Node1 node1) {
        node1.next = head.next;
        node1.prev = head;

        head.next.prev = node1;
        head.next = node1;
    }

    // -----------------------------
    // Remove a node from Doubly Linked List
    // -----------------------------
    private void remove(Node1 node) {
        Node1 prev = node.prev;
        Node1 next = node.next; // take those values references

        prev.next = next; // assign those references to the new node next
        next.prev = prev;
    }

    public void put(int key, int value) {

        // key already exists, update its positioning
        if (cache.containsKey(key)) {
            Node1 existingNode = cache.get(key);
            existingNode.value = value;
            remove(existingNode);
            insertAtFront(existingNode);
            return;
        }

        // otherwise if this is new element totally
        Node1 newNode = new Node1(key, value);
        cache.put(key, newNode);

        insertAtFront(newNode);

        // if the capacity of cache is FULL, remove the least recently used element
        if (cache.size() > capacity) {
            Node1 lruNode = tail.prev;
            remove(lruNode);
            cache.remove(lruNode.key);
        }
    }

    // -----------------------------
    // Helper method for debugging
    // -----------------------------
    public void printCache(){
        Node1 curr= head.next;
        System.out.println("Cache: ");
        while (curr!=tail){
            System.out.println("("+curr.key+", "+curr.value+") ");
            curr=curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LRUCache3 cache = new LRUCache3(2);
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
