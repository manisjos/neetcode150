public class LC744 {
    public static void main(String[] args) {
        char[] arr = {'c', 'f', 'j'};
//        char[] arr = {'c'};
        char target = 'c';

        System.out.println("Next Greatest: " + nextGreatestLetter(arr, target));
    }

    static char nextGreatestLetter(char[] arr, char target) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        if (start == arr.length) {
            return arr[0];
        }
        return arr[start];
    }
}
