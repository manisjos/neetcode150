public class SubArrCount {

    public static void main(String[] args) {
        int[] arr = {10, 2, -2, -20, 10};
        int k = -10;
        System.out.println(cntSubarrays(arr, k));
    }

    static int cntSubarrays(int[] arr, int k) {
        int count=0;
        int n=arr.length;

        for (int i=0;i<n;i++){
            int currSum=0;

            for (int j=i;j<n;j++){
                currSum+=arr[j];
                if(currSum==k){
                    count++;
                }
            }
        }
        return count;
    }
}
