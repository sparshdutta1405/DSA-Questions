class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] memo = new int[n][2][3];
        for (int[][] grid : memo) {
            for (int[] row : grid) {
                Arrays.fill(row, -1);
            }
        }

        return solve(0, 1, 2, prices, memo);
    }

    private int solve(int i, int canBuy, int cap, int[] prices, int[][][] memo) {
        if (i == prices.length || cap == 0) {
            return 0;
        }

        if (memo[i][canBuy][cap] != -1) {
            return memo[i][canBuy][cap];
        }

        int profit;
        if (canBuy == 1) {
            int buy = -prices[i] + solve(i + 1, 0, cap, prices, memo);
            int skip = solve(i + 1, 1, cap, prices, memo);
            profit = Math.max(buy, skip);
        } else {
            int sell = prices[i] + solve(i + 1, 1, cap - 1, prices, memo);
            int hold = solve(i + 1, 0, cap, prices, memo);
            profit = Math.max(sell, hold);
        }

        return memo[i][canBuy][cap] = profit;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna