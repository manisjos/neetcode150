public class Order {
    private final int id;
    private final String customerName;
    private final String shippingAddress;
    private final String product;
    private final double amount;

    private Order(Builder builder){
        this.id = builder.id;
        this.amount = builder.amount;
        this.customerName = builder.customerName;
        this.shippingAddress = builder.shippingAddress;
        this.product = builder.product;
    }

    public int getId() {
        return id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public String getProduct() {
        return product;
    }

    public double getAmount() {
        return amount;
    }

    public static class Builder {
        private  int id;
        private  String customerName;
        private  String shippingAddress;
        private  String product;
        private  double amount;

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Builder setCustomerName(String customerName) {
            this.customerName = customerName;
            return this;
        }

        public Builder setShippingAddress(String shippingAddress) {
            this.shippingAddress = shippingAddress;

            return this;
        }

        public Builder setProduct(String product) {
            this.product = product;

            return this;
        }

        public Builder setAmount(double amount) {
            this.amount = amount;

            return this;
        }

        public Order build(){
            return  new Order(this);
        }
    }

    public static void main(String[] args) {
        Order order
                = new Order.Builder().setId(123)
                .setCustomerName("Sini John").setShippingAddress("Liverpool Street").build();
        Order order1
                = new Order.Builder().setId(123).setShippingAddress("aws").build();
        System.out.println("Order Id: "+order.getId()+" and Customer Name: "+order.getCustomerName());
        System.out.println("Order Id: "+order1.getId()+" and Customer Name: "+order1.getCustomerName());
    }
}
