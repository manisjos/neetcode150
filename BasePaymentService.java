public class BasePaymentService implements PaymentService {

    public void pay(double amount) {
        System.out.println("Processing payment: " + amount);

    }
}
