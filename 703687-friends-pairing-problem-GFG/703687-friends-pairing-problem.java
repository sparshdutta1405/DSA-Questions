class Solution {
    public int countFriendsPairings(int n) {
        // code here
        int [] dp = new int [n+1];
        if(n ==0) return 1;
        if(n ==1 ) return 1;
        if(n ==2 ) return 2;
        
        dp [0]= 1;
        dp[1]= 1;
        dp [2]=2;
        for( int  i = 3 ; i <= n ; i++){
            dp[i] = dp[i-1]+(i-1)*dp[i-2];
        }
        return dp[n];
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna