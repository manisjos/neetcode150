import java.util.concurrent.CompletableFuture;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class EvenOddPrinterStream {

    private static Object object = new Object();
    private static IntPredicate evenCondition = e -> e % 2 == 0;
    private static IntPredicate oddCondition = e -> e % 2 != 0;

    public static void main(String[] args) throws InterruptedException {
        CompletableFuture.runAsync(() -> EvenOddPrinterStream.printNum(oddCondition));
        CompletableFuture.runAsync(() -> EvenOddPrinterStream.printNum(evenCondition));
        Thread.sleep(1000);
    }

    public static void printNum(IntPredicate condin) {
        IntStream.rangeClosed(1, 10).filter(condin).forEach(EvenOddPrinterStream::execute);
    }

    public static void execute(int no) {
        synchronized (object) {
            try {
                System.out.println(Thread.currentThread().getName() + " : " + no);
                object.notify();
                object.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

