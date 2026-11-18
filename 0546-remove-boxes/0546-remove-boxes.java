class Solution {
    public int removeBoxes(int[] boxes) {
        int n = boxes.length;
        int[][][] memo = new int[n][n][n];
        return solve(0, n - 1, 0, boxes, memo);
    }

    private int solve(int l, int r, int k, int[] boxes, int[][][] memo) {
        if (l > r) {
            return 0;
        }

        
        int origL = l;
        int origK = k;
        while (l < r && boxes[l] == boxes[l + 1]) {
            l++;
            k++;
        }

        if (memo[origL][r][origK] != 0) {
            return memo[origL][r][origK];
        }


        int maxPoints = (k + 1) * (k + 1) + solve(l + 1, r, 0, boxes, memo);

        for (int m = l + 1; m <= r; m++) {
            if (boxes[m] == boxes[l]) {
                int points = solve(l + 1, m - 1, 0, boxes, memo) 
                           + solve(m, r, k + 1, boxes, memo);
                maxPoints = Math.max(maxPoints, points);
            }
        }

        return memo[origL][r][origK] = maxPoints;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna