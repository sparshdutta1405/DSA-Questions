class Solution {
    static int matrixMultiplication(int arr[]) {
        int n = arr.length;
        int[][] dp = new int[n][n];
        
        
        for(int gap = 2; gap < n; gap++){
            for(int i = 1; i + gap<= n ; i++){
                int j = i + gap -1;
                
                dp[i][j] = Integer.MAX_VALUE;
                
                
                for(int k = i; k < j; k++){
                    int cost = dp[i][k] + dp[k+1][j] + arr[i-1]*arr[j]*arr[k];
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }
        return dp[1][n-1];
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna