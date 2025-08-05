import java.util.HashMap;
import java.util.Map;

public class FruitIntoBasket {
    public static void main(String[] args) {
        char[] fruits = {'A', 'B', 'C', 'A', 'C'};
        int result = totalFruit(fruits);
        System.out.println("Max fruits in baskets: " + result); // Output: 3 (e.g., "C", "A", "C")
    }

    private static int totalFruit(char[] fruits) {
        int windowStart = 0, maxLength=0;
        Map<Character,Integer> fruitCountMap = new HashMap<>();

        for (int windowEnd = 0 ; windowEnd<fruits.length; windowEnd++){
            char endFruit = fruits[windowEnd];
            fruitCountMap.put(endFruit,fruitCountMap.getOrDefault(endFruit,0)+1);
            while (fruitCountMap.size()>2){
                char startFruit = fruits[windowStart];
                fruitCountMap.put(startFruit, fruitCountMap.get(startFruit) - 1);
                if (fruitCountMap.get(startFruit) == 0) {
                    fruitCountMap.remove(startFruit);
                }
                windowStart++;
            }

            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }

        return maxLength;
        }
}


