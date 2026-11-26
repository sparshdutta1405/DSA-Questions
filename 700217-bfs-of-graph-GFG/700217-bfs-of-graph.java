class Solution {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        boolean[] visited = new boolean[adj.size() + 1];
        Queue<Integer> queue = new ArrayDeque<>();
        ArrayList<Integer> result = new ArrayList<>();
        
        
        visited[0] = true;
        queue.offer(0);
        
        
        while(!queue.isEmpty()){
            int u = queue.poll();
            // System.out.println(u);
            result.add(u);
            
            for(int v: adj.get(u)){
                if(!visited[v]){
                    visited[v] = true;
                    queue.offer(v);
                }
            }
        }
        
        return result;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna