class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        boolean[] inArray = new boolean[n];

        for(List<Integer> edge: edges){
            int to = edge.get(1);
            inArray[to] = true;
        }


        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(!inArray[i]){
                result.add(i);
            }
        }

        return result;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna