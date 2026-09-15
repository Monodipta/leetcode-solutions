class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int minPrice = prices[0]; // Track the cheapest price to buy
        int maxProfit = 0;        // Track the best profit seen so far

        for (int i = 1; i < prices.length; i++) {
            // If today's price is cheaper than our minimum, update our buy price
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } 
            // Otherwise, calculate the profit if we sell today
            else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }

        return maxProfit;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna