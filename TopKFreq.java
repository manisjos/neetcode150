import java.util.*;

public class TopKFreq {
    public static void main(String[] args) {
        String arr[] = {"i", "love", "leetcode", "i", "love", "coding"};
        int k = 2;
        System.out.println("topKFreqBruteForce--> "+topKFreqBruteForce(arr, k));
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
