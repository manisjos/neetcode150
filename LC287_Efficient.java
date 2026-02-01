public class LC287_Efficient {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 2, 2};
        slowFastApproach(arr);
    }

    static void slowFastApproach(int arr[]) {
        int slow = arr[0], fast = arr[0];
        do {
            slow = arr[slow];
            fast = arr[arr[fast]];
        } while (slow != fast);
        slow = arr[0];
        while (slow != fast) {
            slow = arr[slow];
            fast = arr[fast];
        }
//        return slow;
        System.out.println("missing number: " + slow);
    }
}
