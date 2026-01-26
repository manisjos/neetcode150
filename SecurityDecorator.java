public class SecurityDecorator extends LoggingDecorator{

    public SecurityDecorator(PaymentService paymentService){
        super(paymentService);
    }

    public void pay(double amt){
        if(!checkPermision()){

            throw new RuntimeException("Unauthorized");
        }
        super.pay(amt);
    }

    private boolean checkPermision() {
        return true;
    }

}
