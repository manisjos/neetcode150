public class PaymentDecorator implements PaymentService {
    protected PaymentService wrappedService;

    public PaymentDecorator(PaymentService service) {
        this.wrappedService = service;
    }

    public void pay(double amount) {
        wrappedService.pay(amount);
    }
}
