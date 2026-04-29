public class BookAllocation {
    public static void main(String[] args) {
        int[] arr = {11, 34, 67, 90};
        int k = 2;
        System.out.println("Smallest possible maximum pages: " + findPages(arr, k));
    }

    private static int findPages(int[] arr, int k) {
        int n = arr.length;
        if (k > n) {
            return -1;
        }
        int low = 0, high = 0;
        for (int pages : arr) {
            low = Math.max(low, pages);
            high += pages;
        }
        int result = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isFeasible(arr, k, mid)) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return result;
    }


    /**
     * Checks if we can allocate books such that no student gets more than 'limit' pages.
     */
    private static boolean isFeasible(int[] arr, int k, int mid) {
        int studentRequired = 1;
        int currPageSum = 0;

        for (int pages : arr) {
            // if adding this book exceeds the limit, assign a new student
            if (currPageSum + pages > mid) {
                studentRequired++;
                currPageSum = pages; // current book is the first for the next student
            } else {
                currPageSum += pages;
            }
        }
        return studentRequired <= k; // return true if the number of student used is within the allowed limit k
    }
}
