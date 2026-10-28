import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MinHeapTopKStream {
    public static void main(String[] args) {

        System.out.println("Via Heap Approach");
        System.out.println(Arrays.toString(minHeapK(new int[]{1, 1, 1, 2, 2, 3}, 2)));
        System.out.println(Arrays.toString(minHeapK(new int[]{1,2,1,2,1,2,3,1,3,2}, 2)));
    }

    static int[] minHeapK(int arr[], int k) {
        // Step 1: Count frequencies
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int number : arr) {
            freqMap.put(number, freqMap.getOrDefault(number, 0) + 1);
        }


        // Step 2: Keep a Min-Heap of size K, comparing entries by their frequency
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap =
                new PriorityQueue<>((a, b) -> (Integer.compare(a.getValue(), b.getValue())));
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            minHeap.offer(entry); // inserting each entry into minHeap
            if (minHeap.size() > k) {
                minHeap.poll(); // like if >K, remove elements. So this will remove what ?
            }
        }

        // Step 3: Extract elements from heap into resulting array
        // notice by now the minHeap already has only K elements that we need with <Key, Count> map
        int topKRes[] = new int[k];
        int index = 0;

        while (!minHeap.isEmpty()) {
            topKRes[index++] = minHeap.poll().getKey(); // notice getting the key while polling
        }
        return topKRes;
    }
}
