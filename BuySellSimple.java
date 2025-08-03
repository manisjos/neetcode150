import java.util.Arrays;

public class BuySellSimple{
    public static void main(String[] args) {
            int[] arr = {7,1,5,3,6,4};
            System.out.println((maxProfit(arr)));
    }
    public static int maxProfit(int arr[]){
        int n = arr.length, res = 0;
        int minSoFar = arr[0];
        for (int i=1;i<n;i++){
            minSoFar = Math.min(minSoFar,arr[i]);
            res = Math.max(res,arr[i]-minSoFar);
        }
        return res;
    }
}
