import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {

        int arr[] = {5,8,12,1,7};
        System.out.println(Arrays.toString(boobaSort(arr)));
    }

    private static int[] boobaSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i=0;i<n-1;i++){
            swapped = false;
            for (int j=0;j<n-i-1;j++){
                if(arr[j]>arr[j+1]){
                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapped = true;
                }
            }
            if(!swapped) break;
        }
        return arr;
    }
}
