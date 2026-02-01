import java.util.Arrays;

public class BuySellSimple{
    public static void main(String[] args) {
            int[] arr = {7,1,5,3,6,4};
            System.out.println((maxProfit(arr)));
    }
    public static int maxProfit(int prices[]){
        if (prices == null || prices.length == 0) return 0;

        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            // 1. Calculate potential profit first
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);

            // 2. Then update the minimum price for future days
            minPrice = Math.min(minPrice, prices[i]);
        }

        return maxProfit;
    }
}
