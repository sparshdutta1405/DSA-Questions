class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n = nums.size();
        int minSum = Integer.MAX_VALUE;

        for(int len = l; len <= r; len++){
            int windowSum = 0;

            for(int i = 0; i < len; i++){
                windowSum += nums.get(i);
            }

            if(windowSum > 0){
                minSum = Math.min(minSum, windowSum);
            }

            for(int i = len; i < n; i++){
                windowSum += nums.get(i) - nums.get(i - len);
                if(windowSum > 0){
                    minSum = Math.min(minSum, windowSum);
                }
            }
        }

        return minSum == Integer.MAX_VALUE ? -1 : minSum;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna