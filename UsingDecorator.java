public class UsingDecorator {
    public static void main(String[] args) {
        PaymentService service =
                new MetricDecorator(
                        new SecurityDecorator(
                                new LoggingDecorator(
                                        new BasePaymentService()
                                )
                        )
                );
        service.pay(100);
    }
}
