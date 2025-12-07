import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MS_TestPractice {
    public static void main(String[] args) {
//        int sum = 0;
//        for (int i = 0, j = 0; i < 5 & j < 5; ++i, j = i + 1) {
//            sum += i;
//            System.out.println(sum);
//        }
//        String str="London";
//        str.chars().forEach((String ch)-> System.out.println(ch));
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction("MJ", 200));
        transactions.add(new Transaction("DJ", 100));
        transactions.add(new Transaction("MJ", 50));
        transactions.add(new Transaction("RJ", 300));
        transactions.add(new Transaction("DJ", 400));

        Map<String, Integer> result = new MS_TestPractice().calcTotal(transactions);

        System.out.println(result);


    }
    public Map<String,Integer> calcTotal(List<Transaction> transactionList){
        Map<String, Integer> map = new HashMap<>();
        if(transactionList==null)
            return map;

        for (Transaction t :transactionList){
            if(t==null) continue;
            map.merge(t.getUser(),t.getAmount(),Integer::sum);
        }
        return map;
    }
}
