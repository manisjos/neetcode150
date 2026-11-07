public class PayService {
    private final FeeStrategy feeStrategy;

    public PayService(FeeStrategy feeStrategy) {
        this.feeStrategy = feeStrategy;
    }

    public void pay(double amount) {
        double fee = feeStrategy.calculateFee(amount);
        System.out.println("Amount: " + amount);
        System.out.println("Fee: " + fee);
        System.out.println("Total: " + (amount + fee));
    }

    public static void main(String[] args) {
        FeeStrategy cardStrategy = new CardFeeStrategy();
        PayService cardService = new PayService(cardStrategy);

        cardService.pay(100);

        FeeStrategy upiStrategy = new UpiFeeStrategy();
        PayService upiService = new PayService(upiStrategy);

        upiService.pay(100);


        FeeStrategy hawalaStrategy = new HawalaFeeStrategy();
        PayService hawalaService = new PayService(hawalaStrategy);

        hawalaService.pay(100);
    }
}
