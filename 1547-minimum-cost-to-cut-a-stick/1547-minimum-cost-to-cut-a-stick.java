class Solution {
    public int minCost(int n, int[] cuts) {
        int m = cuts.length;

        Arrays.sort(cuts);
        int[] newCut = new int[m+2];
        newCut[0] = 0;
        System.out.println(newCut.length);
        newCut[newCut.length - 1] = n;
        for(int i = 1; i <= m; i++){
            newCut[i] = cuts[i - 1];
        } 

        for(int k = 0; k < newCut.length; k++){
            System.out.println(newCut[k]);
        }


        int[][] memo = new int[m + 2][m + 2];
        for(int[] mem: memo){
            Arrays.fill(mem, -1);
        }

        return cost(newCut, 0, newCut.length-1, memo);
    }

    private int cost(int[] cuts,  int i, int j, int[][] memo){
        if (j <= i + 1) {
            return 0;
        }

        if(memo[i][j] != -1){
            return memo[i][j];
        }

        int res = Integer.MAX_VALUE;

        for(int k = i+1; k < j; k++){
            int current = cost(cuts, i, k, memo) + cost(cuts,  k, j, memo) + cuts[j]-cuts[i];
            res = Math.min(current, res);
        }

        memo[i][j] = res;
        return res;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna