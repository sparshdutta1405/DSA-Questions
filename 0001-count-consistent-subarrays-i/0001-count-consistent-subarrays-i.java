class Solution {
    public int countConsistent(int[] nums) {
        int n = nums.length;
        int consistentCount = 0;

        for(int i = 0; i <n; i++){
            int currentAnd = nums[i];
            int currentMin = nums[i];

            for(int j = i; j < n; j++)
            {
                currentAnd &= nums[j];
                if(nums[j] < currentMin){
                    currentMin = nums[j];
                }

                if(currentAnd == currentMin){
                    consistentCount++;
                }
            }
        }
        return consistentCount;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna