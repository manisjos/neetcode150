public class LC1497 {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 10, 6, 7, 8, 9};
        int k = 5;
        System.out.println(canArrange(arr, k));
    }

    public static boolean canArrange(int[] arr, int k) {
        int[] map = new int[k];
        for (int element : arr) {
            int rem = ((element % k) + k) % k;
            map[rem]++;
        }
        if (map[0] % 2 != 0) {
            return false;
        }
        for (int rem = 1; rem <= k / 2; rem++) {
            int comp = k - rem;
            if (map[rem] != map[comp]) {
                return false;
            }
        }
        return true;
    }
}
