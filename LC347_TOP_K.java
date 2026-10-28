import java.util.*;

public class LC347_TOP_K {
    public static void main(String[] args) {
        System.out.println("Via Naive Approach");
        System.out.println((topKFrequent_Naive(new int[]{1, 1, 1, 2, 2, 3}, 2)));
        System.out.println("Via Heap Approach");
        System.out.println(Arrays.toString(topK_Via_Heap(new int[]{1, 1, 1, 2, 2, 3}, 2)));
        System.out.println("Via Bucket Sort");
        System.out.println(Arrays.toString(topK_Via_BucketSort(new int[]{1, 1, 1, 2, 2, 3}, 2)));
    }

    static int[] topK_Via_BucketSort(int[] arr, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int n : arr) {
            freqMap.put(n, freqMap.getOrDefault(n, 0) + 1);
        }

        @SuppressWarnings("unchecked")
        List<Integer>[] frequencyBuckets = new List[arr.length + 1];
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            int element = entry.getKey();
            int freq = entry.getValue();

            if (frequencyBuckets[freq] == null) {
                frequencyBuckets[freq] = new ArrayList<>();
            }
            frequencyBuckets[freq].add(element);
        }

        int[] topKResult = new int[k];
        int resultIndex = 0;
        for (int freq = frequencyBuckets.length - 1; freq >= 0 && resultIndex < k; freq--) {
            if (frequencyBuckets[freq] != null) {
                for (int element : frequencyBuckets[freq]) {
                    topKResult[resultIndex++] = element;
                    if (resultIndex == k) {
                        break;
                    }
                }
            }
        }

        return topKResult;
    }



    public static ArrayList<Integer> topKFrequent_Naive(int[] nums, int rank) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
//            map.put(num,map.getOrDefault(num,0)+1);
            map.merge(num, 1, Integer::sum);
        }
        ArrayList<int[]> freq = new ArrayList<>();
        // moving the o/p to array list of integer arrays
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            freq.add(new int[]{entry.getKey(), entry.getValue()});
        }
        freq.sort(new Compare());
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < rank; i++) {
            res.add(freq.get(i)[0]);
        }
        return res;
    }

    public static int[] topK_Via_Heap(int[] nums, int k) {
//        This gets O(n log k) complexity instead of O(n log n).
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
//            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());

        for (Map.Entry<Integer, Integer> en : freqMap.entrySet()) {
            minHeap.offer(en);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int[] res = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            res[i] = minHeap.poll().getKey();
        }
        return res;
    }

}
