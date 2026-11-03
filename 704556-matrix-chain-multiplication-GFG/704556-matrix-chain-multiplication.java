class Solution {
    static int matrixMultiplication(int arr[]) {
        // code here
        int n = arr.length;
        
        int[][] memo = new int[n][n];
        
        for(int[] row: memo){
            Arrays.fill(row, -1);
        }
        
        return fxn(1, n-1, arr, memo);
    }
    
    private static int fxn(int i, int j, int[] arr, int[][] memo){
        if(i >= j){
            return 0;
        }
        
        if(memo[i][j] != -1){
            return memo[i][j];
        }
        
        int minCost = Integer.MAX_VALUE;
        
        for(int k = i; k < j; k++){
            int cost = fxn(i, k, arr, memo) + fxn(k+1, j, arr, memo) + arr[i-1] * arr[k] * arr[j];
            minCost = Math.min(minCost, cost);
        }
        
        return memo[i][j] = minCost;
    }
    
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna