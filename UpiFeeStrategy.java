public class UpiFeeStrategy implements FeeStrategy{

    @Override
    public double calculateFee(double amount) {
        return amount;
    }
}
