import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumer {
    private static final Queue<Integer> buffer = new LinkedList<>();
    private static final int CAPACITY = 5;

    public static void produce(int value) throws InterruptedException {
        synchronized (buffer) {
            while (buffer.size() == CAPACITY) {
                System.out.println("Buffer full, producer waiting...");
                buffer.wait(); // wait until consumer consumes
            }
            buffer.add(value);
            System.out.println("Produced: " + value);
            buffer.notifyAll(); // notify consumers
        }
    }

    public static int consume() throws InterruptedException {
        synchronized (buffer) {
            while (buffer.isEmpty()) {
                System.out.println("Buffer empty, consumer waiting...");
                buffer.wait(); // wait until producer produces
            }
            int value = buffer.poll();
            System.out.println("Consumed: " + value);
            buffer.notifyAll(); // notify producers
            return value;
        }
    }

    public static void main(String[] args) {
        Thread producer = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    produce(i);
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        Thread consumer = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    consume();
                    Thread.sleep(150);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        producer.start();
        consumer.start();
    }
}
