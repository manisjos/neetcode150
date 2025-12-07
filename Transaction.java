public class Transaction {
    private String user;
    private int amount;

    public Transaction(String user, int amount) {
        this.user = user;
        this.amount = amount;
    }
    public String getUser(){
        return user;
    }
    public int getAmount(){
        return amount;
    }
}
