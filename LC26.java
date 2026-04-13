public class LC26 {
    public static void main(String[] args) {
        int arr[] = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicatesProper(arr));
    }

    private static int removeDuplicatesProper(int[] arr) {
        if (arr.length == 0) return 0;
        int left = 0;
        for (int right = 1; right < arr.length; right++) {
            if (arr[right] != arr[left]) {
                left++; // move slow pointer
                arr[left] = arr[right]; // overwrite duplicates
            }
        }
        return left + 1; // number of unique elements
    }

}
