package LeetCode.NOT_SOLVED;

// 121. Best Time to Buy and Sell Stock

/**
 * <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/">...</a>
 */

public class _121 {
    public static void main(String[] args) {
        int[] prices1 = {1, 2};
        System.out.println(maxProfit(prices1));

        int[] prices2 = {2, 4, 1};
        System.out.println(maxProfit(prices2));

        int[] prices3 = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices3));

        int[] prices4 = {7, 6, 4, 3, 1};
        System.out.println(maxProfit(prices4));
    }

    /*
    Example 1:
    Input: prices = [7,1,5,3,6,4]
    Output: 5
    Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
    Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

    Example 2:
    Input: prices = [7,6,4,3,1]
    Output: 0
    Explanation: In this case, no transactions are done and the max profit = 0.
     */

    public static int maxProfit(int[] prices) {
        int minPriceIdx = getMinPriceIdx(prices);
        int maxPriceIdx = getMaxPriceIdx(prices);
        return prices[maxPriceIdx] - prices[minPriceIdx];
    }

    // min price idx => any normal approach to find min idx in array.
    private static int getMinPriceIdx(int[] prices) {
        int minPriceIdx = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
                minPriceIdx = i;
            }
        }
        return minPriceIdx;
    }

    // max price => must be SAME AS or AFTER min price idx.
    private static int getMaxPriceIdx(int[] prices) {
        int maxPriceIdx = getMinPriceIdx(prices);
        int maxPrice = Integer.MIN_VALUE;
        for (int i = maxPriceIdx; i < prices.length; i++) {
            if (prices[i] > maxPrice) {
                maxPrice = prices[i];
                maxPriceIdx = i;
            }
        }
        return maxPriceIdx;
    }
}
