import java.util.*;

public class LC1418_Orders {
    public static void main(String[] args) {
        List<List<String>> orders = List.of(
                List.of("David", "3", "Jain Ceviche"),
                List.of("Corina", "10", "Jain Burrito"),
                List.of("David", "3", "Fried Garlic Paneer"),
                List.of("Carla", "5", "Water"),
                List.of("Carla", "5", "Lasan vagar Ceviche"),
                List.of("Rous", "3", "Jain Ceviche")
        );
        System.out.println("Printing Order Table: \n" + displayTable(orders));
    }

    public static List<List<String>> displayTable(List<List<String>> orders) {
//        Orders
//  ↓ group by table
//        TreeMap<Table, List<Food>>
//  ↓ count per table
//        Map<Food, Count>
//  ↓ align with sorted header
//        2D Output Table

        TreeMap<Integer, List<String>> tables = new TreeMap<>();
        Set<String> items = new HashSet<>();
        for (List<String> o : orders) {
            int table = Integer.parseInt(o.get(1));
            String foodItem = o.get(2);
            tables.computeIfAbsent(table, x -> new ArrayList<>()).add(foodItem);
            items.add(foodItem);
        }

        List<String> sortedItems = new ArrayList<>(items);
        Collections.sort(sortedItems);
        List<List<String>> ans = new ArrayList<>();
        List<String> header = new ArrayList<>();
        header.add("Table");
        header.addAll(sortedItems);
        ans.add(header);

        for (Map.Entry<Integer, List<String>> entry : tables.entrySet()) {
            Map<String, Integer> cnt = new HashMap<>();
            for (String item : entry.getValue()) {
                cnt.merge(item, 1, Integer::sum);
            }
            List<String> row = new ArrayList<>();
            row.add(String.valueOf(entry.getKey()));
            for (String item : sortedItems) {
                row.add(String.valueOf(cnt.getOrDefault(item, 0)));
            }
            ans.add(row);
        }
        return ans;
    }
}
