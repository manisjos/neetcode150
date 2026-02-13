import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {

        int arr[] = {2, 4, 1, 7, 8, 0, 9};
        sort(arr);
        System.out.println(Arrays.toString(arr));

    }

    static void sort(int[] array) {
        executeQuickSort(array, 0, array.length - 1);
    }

    static void executeQuickSort(int[] arr, int leftIndex, int rightIndex) {
        if (leftIndex < rightIndex) {
            int pivotFinalPosition = partition(arr, leftIndex, rightIndex);

            executeQuickSort(arr, leftIndex, rightIndex - 1);
            executeQuickSort(arr, pivotFinalPosition + 1, rightIndex);
        }
    }

    static int partition(int arr[], int leftIndex, int rightIndex) {
        // We choose the last element as our comparison anchor (the pivot)
        int pivotValue = arr[rightIndex];

        // This pointer tracks the 'wall' between small elements and large elements.
        // Everything to the left of (and including) this index is smaller than the pivot.
        int lastSmallElementIndex = leftIndex - 1;
        // Iterate through the current segment (excluding the pivot itself)
        for (int exploreIndex = leftIndex; exploreIndex < rightIndex; exploreIndex++) {

            // If we find a value smaller than our pivot...
            if (arr[exploreIndex] < pivotValue) {
                // ...expand the 'small zone' by one slot...
                lastSmallElementIndex++;

                // ...and swap the small value into that new slot.
                swap(arr, lastSmallElementIndex, exploreIndex);
            }
        }

        // Final Step: Move the pivot from the end of the array to its
        // correct sorted position (right after the last small element).
        int finalPivotIndex = lastSmallElementIndex + 1;
        swap(arr, finalPivotIndex, rightIndex);
        return finalPivotIndex;
    }

    static void swap(int arr[], int firstIndex, int secondIndex) {
        int temp = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = temp;
    }
}
