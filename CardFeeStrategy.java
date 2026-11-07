public class CardFeeStrategy implements FeeStrategy{
    @Override
    public double calculateFee(double amount){
        return amount*0.02;
    }
}
