public class Accn_min_max {
    public static void main(String[] args) {

        int arr[] = {3, 4, 5, 12, 33, 11};
//        int arr[] = {3};
        int min = arr[0];
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
            if (arr[i] > min) {
                max = arr[i];
            }
        }
        System.out.println("Min: " + min + " and Max: " + max);
        //
    }
}
