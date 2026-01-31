public class LC53_maxSubArray {
    public static void main(String[] args) {

//        int arr[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int arr[] = {1, 2, 3, 4, 5};
        printAllBrutForce(arr);
        brutForce(arr);
        viaKadaneAlgo(arr);
    }

    static void viaKadaneAlgo(int arr[]) {
        int n = arr.length, currSum = 0, maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            currSum += arr[i];
            maxSum = Math.max(currSum, maxSum);
            if (currSum < 0) {
                currSum = 0;
            }
        }
        System.out.println("Maximum SubArr using kadane's Algo: " + maxSum);
    }

    static void brutForce(int arr[]) {
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        for (int start = 0; start < n; start++) {
            int currSum = 0;
            for (int end = start; end < n; end++) {
                currSum += arr[end];
                if (currSum > max) {
                    max = currSum;
                }
            }
            System.out.println();
        }
        System.out.println("Maximum SubArr using bruteforce approach: " + max);
    }

    static void printAllBrutForce(int arr[]) {
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        for (int start = 0; start < n; start++) {
            for (int end = start; end < n; end++) {
                int currSum = 0;
                for (int i = start; i <= end; i++) {
                    System.out.print(arr[i]);
                    currSum += arr[i];
                }
                if (currSum > max) {
                    max = currSum;
                }
                System.out.print(" (Sum: " + currSum + ") ");
            }
            System.out.println();
        }
        System.out.println("Maximum SubArr: " + max);
    }
}
