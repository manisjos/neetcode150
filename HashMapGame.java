import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashMapGame {
    public static void main(String[] args) {
        List<String[]> orders = List.of(
                new String[]{"User_1","iphone"},
                new String[]{"User_2","mcbook"},
                new String[]{"User_2","iphone"},
                new String[]{"User_1","mcbook"},
                new String[]{"User_2","iphone"},
                new String[]{"User_1","mcbook"}
        );
        Map<String,List<String>> custOrders = new HashMap<>();
        Map<String, Integer> itemsSold = new HashMap<>();

        for (String[] order:orders){
            String custName = order[0];
            String itemName = order[1];

            custOrders.computeIfAbsent(custName,
                    k-> new ArrayList<>()).add(itemName);
            System.out.println(custName);
        }

    }
}
