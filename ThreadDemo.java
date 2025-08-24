import java.util.concurrent.*;

public class ThreadDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newSingleThreadExecutor();
        Callable<Integer> task = () -> {
            System.out.println("Callable running : " + Thread.currentThread().getName());
            return 42;
        };
        Future<Integer> future = service.submit(task);
        System.out.println("Result = "+future.get());
        service.shutdown();
    }
}
