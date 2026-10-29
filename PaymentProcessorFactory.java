import java.util.Locale;

public class PaymentProcessorFactory{
    public static PaymentProcessor getPaymentProcessor(String type){
        switch (type.toUpperCase()){
            case "CARD":
                return new Card();
            case "UPI":
                return new Upi();
            case "HAWALA":
                return new hawala();
            default:
                throw new IllegalArgumentException(
                        "Unsupported payment type: "+type);
        }
    }

    public static void main(String[] args) {
        PaymentProcessor processor =  PaymentProcessorFactory.getPaymentProcessor("Card");
        processor.pay(40);
    }
}
