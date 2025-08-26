import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CpuIntensiveTask implements Runnable{
    @Override
    public void run() {
        System.out.println("do something: "+Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        int coreCount = Runtime.getRuntime().availableProcessors();
        System.out.println(coreCount+" cores");
        ExecutorService service = Executors.newFixedThreadPool(coreCount);
        for (int i=0;i<8;i++){
            service.execute(new CpuIntensiveTask());
        }
    }
}
