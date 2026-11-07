import java.util.ArrayDeque;
import java.util.Deque;

class Solution {

    private static class Node{
        int type;
        int color;
        int count;

        Node(int type, int color, int count){
            this.type = type;
            this.color = color;
            this.count = count;
        }
    }
    
    public boolean canRemoveAll(int[] types, int[] colors, int[] groupSize) {
        Deque<Node> stack = new ArrayDeque<>();
        int n = types.length;

        for(int i = 0; i < n; i++){
            int t = types[i];
            int c = colors[i];

            if(!stack.isEmpty() && stack.peek().type == t && stack.peek().color == c){
                stack.peek().count++;
            }else{
                stack.push(new Node(t, c, 1));
            }

            if(stack.peek().count == groupSize[t]){
                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna