public class Upi implements PaymentProcessor{

    @Override
    public void pay(double amount){
        System.out.println("Paying via Upi "+amount);
    }
}
