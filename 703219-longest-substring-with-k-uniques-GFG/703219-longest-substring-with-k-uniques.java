class Solution {
    public int longestKSubstr(String s, int k) {
        // code here
        
        int n = s.length();
            
        Map<Character, Integer> map = new HashMap<>();
        
        int j = 0;
        int i = 0;
        
        int result = -1;
        
        while(j < n){
            
            char rightChar = s.charAt(j);
            map.put(rightChar, map.getOrDefault(rightChar, 0) + 1);
            
            while(map.size() > k){
                char leftChar =  s.charAt(i);
                
                if(map.get(leftChar) > 1){
                    map.put(leftChar, map.get(leftChar) - 1);
                }else{
                    map.remove(leftChar);
                }
                
                i++;
            }
            
            if(map.size() == k){
                result = Math.max(result, j - i + 1);
            }
            
            
            j++;
            
        }
        
        return result;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna