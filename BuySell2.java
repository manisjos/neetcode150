public class BuySell2 {

    public static void main(String[] args) {
        int[] prices = {100, 180, 260, 310, 40, 535, 695};
        System.out.println(maxProfit(prices));

    }

    private static int maxProfit(int[] prices) {
        return maxProfitRec(prices, 0, prices.length - 1);
    }

    private static int maxProfitRec(int[] prices, int start, int end) {
        int res = 0;
        for (int i = start; i < end; i++) {
            for (int j = i + 1; j <= end; j++) {

                if (prices[i] > prices[j]) {
                    int curr = (prices[j] - prices[i]) +
                            maxProfitRec(prices, start, i - 1) +
                            maxProfitRec(prices, j + 1, end);
                    res = Math.max(res, curr);
                }
            }
        }
        return res;
    }
}
