public class LC1423 {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 1};
        int k = 3;
        System.out.println("Max Score: " + maxScore(arr, k));
    }

    static int maxScore(int arr[], int k) {
//        Main Trick
//
//        Instead of choosing k cards to take...
//
//        Think:
//
//👉 which cards are left behind?
//
//                If total cards = n
//        and we take k
//
//        then remaining cards = n - k
//
//        Those remaining cards will always be a continuous subarray in the middle.
//
//        So:
//
//        Answer =
//                total sum - minimum subarray sum of size (n-k)

        int totalSum = 0;
        for (int points : arr) {
            totalSum += points;
        }
        int totalCards = arr.length;
        if (k == totalCards) {
            return totalSum;
        }

        int windowSize = totalCards - k; //
        int currWinSum = 0;
        for (int i = 0; i < windowSize; i++) {
            currWinSum += arr[i];
        }

        int minWinSum = currWinSum;
        for (int right = minWinSum; right < totalCards; right++) {
            currWinSum += arr[right];
            currWinSum -= arr[right - windowSize];
            minWinSum = Math.min(minWinSum, currWinSum);
        }
        return totalSum - minWinSum;
    }
}
