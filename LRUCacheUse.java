public class LRUCacheUse {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2); // capacity = 2

        cache.put(1, 1); // cache: {1=1}
        cache.put(2, 2); // cache: {2=2, 1=1}

        System.out.println(cache.get(1)); // returns 1
        // cache becomes: {1=1, 2=2}

        cache.put(3, 3); // evicts key 2
        // cache becomes: {3=3, 1=1}

        System.out.println(cache.get(2)); // returns -1 (not found)

        cache.put(4, 4); // evicts key 1
        // cache becomes: {4=4, 3=3}

        System.out.println(cache.get(1)); // returns -1
        System.out.println(cache.get(3)); // returns 3
        System.out.println(cache.get(4)); // returns 4
    }
}
