public class OddEvenPrinter {
    private static final int MAX = 10;
    private int counter = 1;

    public static void main(String[] args) {
        OddEvenPrinter printer = new OddEvenPrinter();


        Thread oddThread = new Thread(printer::printOdd, "Odd-Thread");
        Thread evenThread = new Thread(printer::printEven, "Even-Thread");

        oddThread.start();
        evenThread.start();
    }
    synchronized void printEven(){
        while (counter<=MAX){
            while (counter%2!=0){
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            if (counter <= MAX) {
                System.out.println(Thread.currentThread().getName() + " -> " + counter);
                counter++;
                notify();
            }
        }
    }

    public synchronized void printOdd() {
        while (counter <= MAX) {
            while (counter % 2 == 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            if (counter <= MAX) {
                System.out.println(Thread.currentThread().getName() + " -> " + counter);
                counter++;
                notify();
            }
        }
    }
}
