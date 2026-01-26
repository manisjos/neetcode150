public class LoggingDecorator extends PaymentDecorator{
    public LoggingDecorator(PaymentService service){
        super(service);
    }

    public void pay(double amt){
        System.out.println("LOG: Payment Started");
        super.pay(amt);
        System.out.println("LOG: Payment Completed");
    }
}
