class Solution {
    static List<Integer> firstNegInt(int arr[], int k) {
        // code here
        int n = arr.length;
        List<Integer> result = new ArrayList<>();
        Queue<Integer> q = new ArrayDeque<>();
        
        int left = 0;
        
        for(int right = 0; right < n; right++){
            if(arr[right] < 0){
                q.offer(right);
            }
            
            
            if(right - left + 1 == k){
                while(!q.isEmpty() && q.peek() < left){
                    q.poll();
                }
                
                if(q.isEmpty()){
                    result.add(0);
                }else{
                    result.add(arr[q.peek()]);
                }
                
                left++;
            }
        }
        
        return result;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna