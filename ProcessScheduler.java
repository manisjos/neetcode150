import java.util.Collections;
import java.util.PriorityQueue;

public class ProcessScheduler {
    public static void main(String[] args) {
        int[] ability = {3, 1, 7, 2, 4};
        int processes = 15;
        System.out.println("Min seconds: " + minSec(ability, processes));
    }

    static int minSec(int ability[], int processes) {
        PriorityQueue<Integer> maxHeap =
                new PriorityQueue<>(Collections.reverseOrder());
        for (int cap : ability) {
            maxHeap.add(cap);
        }
        int seconds = 0;
        while (processes > 0 && !maxHeap.isEmpty()) {
            int currMax = maxHeap.poll();
            processes -= currMax;
            seconds++;

            int newAb = currMax / 2;
            if (newAb > 0) {
                maxHeap.add(newAb);
            }
        }
        return processes <= 0 ? seconds : -1;
    }
}
