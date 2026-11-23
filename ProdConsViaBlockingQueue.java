import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProdConsViaBlockingQueue {

    private final BlockingQueue<Integer> queue;

    ProdConsViaBlockingQueue(int capacity) {
        this.queue = new ArrayBlockingQueue<>(capacity);
    }

    public void produce(int value) throws InterruptedException {
        queue.put(value); // Blocks automatically if the queue is full
        System.out.println("Produced: " + value);
    }

    public int consume() throws InterruptedException {
        int value = queue.take(); // Blocks automatically if the queue is empty
        System.out.println("Consumed: " + value);
        return value;
    }

    public static void main(String[] args) {
        ProdConsViaBlockingQueue pc = new ProdConsViaBlockingQueue(5);

        Thread producerThread = new Thread(() -> {
            try {
                for (int i = 0; i <= 10; i++) {
                    pc.produce(i);
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        });

        Thread consumerThread = new Thread(() -> {
            try {
                for (int i = 0; i <= 10; i++) {
                    pc.consume();
                    Thread.sleep(150);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        });

        producerThread.start();
        consumerThread.start();
    }
}