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
    // GET
    public int get(int key){
//        if get(1), make it 1->3->2
        if(!cache.containsKey(key)){
            return -1;
        }
        Node node =cache.get(key);
        // Since this was accessed, move it to the front
//        remove(node);
//        insertAtFront(node);

        return node.value;
    }

}
