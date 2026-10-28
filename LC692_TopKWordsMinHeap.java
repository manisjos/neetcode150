import java.util.*;

public class LC692_TopKWordsMinHeap {
    public static void main(String[] args) {
        String arr[] = {"i", "love", "leetcode", "i", "love", "coding"};
        int k = 2;
        System.out.println("Top K repeating words: " + topKWords(arr, k));
    }

    static List<String> topKWords(String words[], int k) {
        // s1: count freq of each word
        Map<String, Integer> countMap = new HashMap<>();
        for (String word : words) {
            countMap.put(word, countMap.getOrDefault(word, 0) + 1);
        }

        // s2: build a minHeap with custom comparator
        PriorityQueue<String> minHeap = new PriorityQueue<>
                ((w1, w2) -> {
                    int freq1 = countMap.get(w1);
                    int freq2 = countMap.get(w2);
                    if (freq1 != freq2) {
                        // lower frequency stays at the top of the heap
                        return Integer.compare(freq1, freq2);
                    }
                    // for same freq, reverse alphabetical order stays at the top
                    return w2.compareTo(w1); // lex comparision library method, when both word freq are same.
                }
                );

        // s3: keep the heap size bounded by k
        for (String word : countMap.keySet()) {
            minHeap.add(word);
            if (minHeap.size() > k) {
                minHeap.poll(); // remove the least freq / lexically larger element
            }
        }


        // s4: Pop elements from heap and reverse to get the correct order
        List<String> result = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            result.add(minHeap.poll()); // since only String in the PriorityQ, we dont need to getKey
        }
        Collections.reverse(result); // this is an explicit requirement in the code to get
        // Return the answer sorted by the frequency from highest to lowest. Sort the words with the same frequency by their lexicographical order.

        return result;
    }

}
