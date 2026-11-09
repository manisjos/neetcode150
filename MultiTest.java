public class MultiTest {
    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            System.out.println(Thread.currentThread().getName());
        });
        t1.run();
        t1.start();


        Object o=new Object();
        Thread t2=new Thread(()->{
            synchronized (o){
                try {
                    System.out.println("waiting...");
                    o.wait();
                    System.out.println("Resumed!...");
                } catch (InterruptedException e){
                    Thread.currentThread().interrupt();
                }
            }
        });
        Thread t3= new Thread(()->{
            synchronized (o){
                System.out.println("Notifying...");
                o.notify();
            }
        });

        t2.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
        t3.start();
    }
}
