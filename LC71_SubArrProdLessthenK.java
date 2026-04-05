public class LC71_SubArrProdLessthenK {
    public static void main(String[] args) {

        int arr[] = {10, 5, 2, 6};
        int k = 100;
        subArrProdMax(arr, k);
    }

    private static void subArrProdMax(int[] arr, int k) {
        if (k <= 0) {
            System.out.println("0");
        }
        int left = 0;
        int product = 1;
        int count = 0;

        for (int right = 0; right < arr.length; right++) {
            product *= arr[right];
            while (product >= k) {
                product /= arr[left]; // notice we are diving (since we removing left most element - to reduce our window and slide)
                left++; // moving pointer ahead
            }
            count += (right - left + 1);
        }
        System.out.println("Total Count of Such : " + count);
    }
}
