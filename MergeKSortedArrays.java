import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

 public class MergeKSortedArrays {

    // Simple static holder class without implementing Comparable
    private static class Element {
        final int value;
        final int arrayIndex;
        final int elementIndex;

        Element(int value, int arrayIndex, int elementIndex) {
            this.value = value;
            this.arrayIndex = arrayIndex;
            this.elementIndex = elementIndex;
        }
    }

    public static int[] mergeKSortedArrays(int[][] arrays) {
        if (arrays == null || arrays.length == 0) {
            return new int[0];
        }

        int totalLength = 0;
        int activeArrays = 0;

        for (int[] arr : arrays) {
            if (arr != null && arr.length > 0) {
                totalLength += arr.length;
                activeArrays++;
            }
        }

        if (totalLength == 0) {
            return new int[0];
        }

        // Custom comparator defined directly inside PriorityQueue
        PriorityQueue<Element> minHeap = new PriorityQueue<>(
                activeArrays,
                Comparator.comparingInt(e -> e.value)
        );

        // Step 1: Insert initial element from each array
        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i] != null && arrays[i].length > 0) {
                minHeap.add(new Element(arrays[i][0], i, 0));
            }
        }

        int[] result = new int[totalLength];
        int resultIndex = 0;

        // Step 2: Poll min and insert next element from same array
        while (!minHeap.isEmpty()) {
            Element current = minHeap.poll();
            result[resultIndex++] = current.value;

            int nextElementIndex = current.elementIndex + 1;
            if (nextElementIndex < arrays[current.arrayIndex].length) {
                minHeap.add(new Element(
                        arrays[current.arrayIndex][nextElementIndex],
                        current.arrayIndex,
                        nextElementIndex
                ));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] arrays = {
                {1, 4, 7},
                {2, 5, 8},
                {3, 6, 9}
        };

        int[] mergedArray = mergeKSortedArrays(arrays);
        System.out.println(Arrays.toString(mergedArray));
        // Output: [1, 2, 3, 4, 5, 6, 7, 8, 9]
    }
}