public class Restaurant {
    public static void main(String[] args) {
        Thread t1 = new SimpleThread("Pasta");
        Thread t2 = new SimpleThread("Salad");
        Thread t3 = new SimpleThread("Rotlo");
        Thread t4 = new SimpleThread("HashBrown");
        Thread t5 = new SimpleThread("Baked Beans");
        Thread t6 = new SimpleThread("Chadoodh");
        Thread t7 = new SimpleThread("Toast");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t6.start();
        t5.start();
        t7.start();
    }
}
