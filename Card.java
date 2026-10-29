public class Card implements PaymentProcessor{

    @Override
    public void pay(double amount) {
        System.out.println("Paying via Card "+amount);
    }
}
