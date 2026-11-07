public class HawalaFeeStrategy implements FeeStrategy {
    @Override
    public double calculateFee(double amount) {
        return amount * 0.5;
    }
}
