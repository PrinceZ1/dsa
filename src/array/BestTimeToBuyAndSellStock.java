package array;

public class BestTimeToBuyAndSellStock {

    /**
     * Approach 1: Brute Force
     *
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     */
    public int maxProfitBruteForce(int[] prices) {
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                maxProfit = Math.max(maxProfit, profit);
            }
        }
        return maxProfit;
    }

    /**
     * Approach 2: One Pass
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int maxProfitOnePass(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else {
                maxProfit = Math.max(maxProfit, price - minPrice);
            }
        }
        return maxProfit;
    }

    /**
     * Main method to test all approaches
     */
    public static void main(String[] args) {
        BestTimeToBuyAndSellStock test = new BestTimeToBuyAndSellStock();
        int[] prices = {7, 1, 5, 3, 6, 4};

        System.out.println("Brute Force: " + test.maxProfitBruteForce(prices));
        System.out.println("One Pass (Optimal): " + test.maxProfitOnePass(prices));
    }
}
