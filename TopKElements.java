import java.util.*;

public class TopKElements {
    public static void main(String[] args) {
        int arr[] = {1, 1, 1, 2, 2, 3};
        int k = 2;

        System.out.println("K Most Freq -> "+Arrays.toString(kMostFrequent(arr, k)));
        System.out.println("K Most Freq -> "+Arrays.toString(kMostFrequentOptmisedMinHeapWay(arr, k)));
    }

    static int[] kMostFrequentOptmisedMinHeapWay(int[] arr, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        // Step1: Count Frequencies
        for (int val : arr) {
            map.put(val, map.getOrDefault(val, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer,Integer>> minHeap =
                new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));


        // Step 2: Keep only top K
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

            minHeap.offer(entry);

            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // Step 3: Extract answer
        int[] result = new int[k];

        int index = k - 1;

        while (!minHeap.isEmpty()) {
            result[index--] = minHeap.poll().getKey();
        }

        return result;
    }

    static int[] kMostFrequent(int arr[], int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int val : arr) {
            map.put(val, map.getOrDefault(val, 0) + 1);
        }

        // convert to list
        List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(map.entrySet());

        // sort by frequency descending
        entries.sort((a, b) -> b.getValue() - a.getValue());

        // pick first K elements
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = entries.get(i).getKey();
        }
        return result;
    }
}
