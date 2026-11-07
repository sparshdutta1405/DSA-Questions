class Solution {
    public long countValidSubstrings(String s) {
        int n = s.length();
        long ans = 0;
        int lastInvalidStart = -1;

        for(int i = 0; i < n; i++){
            if(i >= 2 && s.charAt(i - 2) == 'a' && s.charAt(i - 1) == 'b' && s.charAt(i) == 'c'){
                lastInvalidStart = i - 2;
            }

            ans += (i - lastInvalidStart);
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna