public class BlockingQueue<T> {
    private T[] queue;
    private int capacity;
    private int size = 0;
    private int head = 0;
    private int tail = 0;

    @SuppressWarnings("unchecked")
    public BlockingQueue(int capacity) {
        this.capacity = capacity;
        queue = (T[]) new Object[capacity];
    }

    public synchronized void put(T item) throws InterruptedException {
        while (size == capacity) {
            wait(); // wait if Q is full
        }
        queue[tail] = item;
        tail = (tail + 1) % capacity; // why are we modding here
        size++;
        notifyAll();
    }

    public synchronized T take() throws InterruptedException {
        while (size == 0) {
            wait();
        }
        T item = queue[head];
        head = (head + 1) % capacity; // why are we modding here
        size--;
        notifyAll();
        return item;
    }

    public synchronized int size() {
        return size;
    }
}
