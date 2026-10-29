public class hawala implements PaymentProcessor{
    @Override
    public void pay(double amt){
        System.out.println("Paying via Hawala "+amt);
    }
}
