public class MetricDecorator extends PaymentDecorator {
    public MetricDecorator(PaymentService paymentService) {
        super(paymentService);
    }

    public void pay(double amt) {
        long start = System.currentTimeMillis();
        super.pay(amt);
        long end = System.currentTimeMillis();
        System.out.println("Time taken : " + (end - start) + " ms");
    }
}
