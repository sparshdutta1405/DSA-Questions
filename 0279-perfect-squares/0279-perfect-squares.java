class Solution {
    public int numSquares(int n) {
        if(isSquare(n)){
            return 1;
        }

        int temp = n;
        while(temp %4 == 0) {
            temp /= 4;
        }
        if(temp %8 == 7) return 4;

        for (int i = 1; i * i <= n; i++) {
            if (isSquare(n - i * i)) {
                return 2;
            }
        }

        return 3;
    }

    private boolean isSquare(int x){
        int r = (int) Math.sqrt(x);
        return r * r == x;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna