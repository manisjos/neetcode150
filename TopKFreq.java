import java.util.*;

public class TopKFreq {
    public static void main(String[] args) {
        String arr[] = {"i", "love", "leetcode", "i", "love", "coding"};
        int k = 2;
        System.out.println("topKFreqBruteForce--> " + topKFreqBruteForce(arr, k));
        System.out.println("topKFreq Optimal Min Heap Approach--> " + topKFreqOptimized(arr, k));
    }

    static List<String> topKFreqOptimized(String arr[], int k) {

        // Step1: Count frequency of each word
        Map<String, Integer> freqMap = new HashMap<>();
        for (String word : arr) {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }

        // Step2: Create a min heap
        PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>((fE, sE) -> {


            // Lower Frequency has higher priority for removal
            if (!fE.getValue().equals(sE.getValue())) {
                return fE.getValue() - sE.getValue();
            }

            // for same freq, lexicographically larger
            // word has higher priority for removal
            return sE.getKey().compareTo(fE.getKey());
        });


        // Step3: Keep only K entries
        for (Map.Entry<String, Integer> entry : freqMap.entrySet()) {
            minHeap.offer(entry);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }


        // Step4: Extract Result
        List<String> answer = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            answer.add(minHeap.poll().getKey());
        }

        // Since it's a min heap, reverse the result
        Collections.reverse(answer);

        return answer;
    }

    static List<String> topKFreqBruteForce(String arr[], int k) {
        Map<String, Integer> freqMap = new HashMap<>();
        for (String word : arr) {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(freqMap.entrySet());
        entries.sort((firstEntry, secondEntry) -> {
            if (!firstEntry.getValue().equals(secondEntry.getKey())) {
                return secondEntry.getValue() - firstEntry.getValue();
            }
            return firstEntry.getKey().compareTo(secondEntry.getKey());
        });

        List<String> answer = new ArrayList<>();
        for (int index = 0; index < k; index++) {
            answer.add(entries.get(index).getKey());
        }
        return answer;
    }
}
