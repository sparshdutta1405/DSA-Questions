class Solution {
    public int minMoves(int[] nums) {
        int n = nums.length;
        int maxIndex = 0;
        for(int i = 0; i < n;i++){
            if(nums[i] > nums[maxIndex]){
                maxIndex = i;
            }
        }
        int moves = 0;
        for(int num:nums ){
            moves += Math.abs(nums[maxIndex] - num);
        }

        return moves;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna