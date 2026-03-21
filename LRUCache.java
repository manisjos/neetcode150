import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private static class Node {
        int key, val;
        Node prev, next;

        Node(int k, int v) {
            key = k;
            val = v;
        }
    }

    private int capcity;
    private Map<Integer, Node> map = new HashMap<>();
    private Node head, tail;

    public LRUCache(int capcity) {
        this.capcity = capcity;
        map = new HashMap<>();

        head = new Node(0, 0); // dummy head
        tail = new Node(0, 0); // dummy tail
        head.next = tail;
        tail.prev = head;
    }


    //   get method goal ->  Return the value of the key
//    AND mark it as recently used
    public int get(int key) {
        if (!map.containsKey(key)) return -1; // not found -1
        Node node = map.get(key); // get the node to remove from current position
        remove(node);
//      👉 Why remove?  Because this node might be:
//        in the middle, or near tail (old position),
//        We want to reposition it
        insertToHead(node); // 👉 Now it becomes Most Recently Used (MRU)
        return node.val;

//        Before:
//        HEAD <-> A <-> B <-> C <-> TAIL
//        Call:
//        get(B)
//        After:
//        HEAD <-> B <-> A <-> C <-> TAIL
    }

    //    put(int key, int value) - Goals
//    Insert new key OR update existing key
//    Maintain LRU order
//    Evict if needed
    public void put(int key, int value) {
        if(map.containsKey(key)){
            remove(map.get(key));
//            👉 Why remove?
//            Because:
//            Old node is somewhere in list
//            remove, We’ll insert updated version at head
//            ⚠️ Important: avoids duplicate nodes
        }
        Node newNode = new Node(key,value); // preparing new to be added
        map.put(key,newNode); // adding it
        insertToHead(newNode); // ensuring that it is at Head, 👉 Newly inserted = most recently used

        if(map.size()>capcity){
            Node lru = tail.prev; //👉 Node just before tail = least recently used
            remove(lru); // removing it -> remove from linked list
            map.remove(lru.key); // 👉 Keep map and list in sync - remove from hashmap
        }
    }

// whole PUT method flow below
//    Capacity = 2
//    put(1,1)
//    put(2,2)
//    List:
//    HEAD <-> 2 <-> 1 <-> TAIL
//
//    Now:
//    put(3,3)
//    Steps:
//    Insert 3 at head
//    Size = 3 → exceeds capacity
//    Remove LRU → 1
//    Final:
//    HEAD <-> 3 <-> 2 <-> TAIL



    private void remove(Node node) {
//        Before: B is the node input
//        A <-> B <-> C
        node.prev.next = node.next;
//        👉 A.next = C
//        A ----> C
//        B <-> C   (B still points, but A skips B)
        node.next.prev = node.prev; // 👉 C.prev = A
//        A <-> C
//                (B is disconnected)
    }

    private void insertToHead(Node node) {
        // You're inserting the node between HEAD and the old first node
//        HEAD <-> A <-> B, Insert new node X
        node.next = head.next; // 👉 X.next = A
        node.prev = head; // 👉 X.prev = HEAD
//        HEAD   A
//          \  /
//           X
//        (links not fully connected yet)
        head.next.prev = node; // 👉 A.prev = X
        head.next = node; // 👉 HEAD.next = X
        //HEAD <-> X <-> A <-> B
    }
}
