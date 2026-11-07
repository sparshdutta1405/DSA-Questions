class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int m = n + 2;

        int[] val = new int[m];
        val[0] = 1;
        val[m-1] = 1;

        for(int i = 1; i <= n; i++){
            val[i] = nums[i-1];
            System.out.println(val[i]);
        }

        int[][] memo = new int[m][m];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return fxn(0, m-1, val, memo);
    }

    private int fxn(int i, int j, int[] val, int[][] memo){
        if (j <= i + 1) {
            return 0;
        }

        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        int maxCoins = 0;


        for (int k = i + 1; k < j; k++) {
            int coins = fxn(i, k, val, memo) 
                      + fxn(k, j, val, memo) 
                      + val[i] * val[k] * val[j];
            maxCoins = Math.max(maxCoins, coins);
        }

        return memo[i][j] = maxCoins;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna