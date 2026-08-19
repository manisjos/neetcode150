import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class tFK {
    public static void main(String[] args) {
        int arr[] = {1, 1, 1, 2, 2, 3};
        int k = 2;
        System.out.println(Arrays.toString(topKFrequent(arr, k)));
    }

    static int[] topKFrequent(int[] nums, int k) {
        // put meaningful comment and variableName should be meaningful
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        // creating frequency map of values in array
        for (int number : nums) {
            frequencyMap.put(number, frequencyMap.getOrDefault(number, 0) + 1);
        }

        // Min Heap ordering elements by their frequency in ascending order
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(
                (a, b) -> Integer.compare(frequencyMap.get(a), frequencyMap.get(b))
        );

        for (int num : frequencyMap.keySet()) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.poll(); // Evict minimum frequency element
            }
        }

        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = minHeap.poll();
        }

        return result;

    }

}
