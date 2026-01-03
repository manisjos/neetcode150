public class SimpleCoffee implements Coffee {

    @Override
    public double cost() {
        return 50;
    }

    @Override
    public String description() {
        return "Simple Coffee";
    }
}
