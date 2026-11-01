/* Structure for link list Node
class Node {
  public:
    int data;
    public Node next;
    public Node(int val) {
        data = val;
        next = null;
    }
}; */

class Solution {
    public int sumofNodes(Node head, int n) {
        // code here
        if(head == null || n <= 0){
            return 0;
        }
        
        Node lead = head;
        int sum = 0;
        
        for(int i = 0; i < n && lead != null; i++){
            sum += lead.data;
            lead = lead.next;
        }
        
        Node trail = head;
        while(lead != null){
            sum += lead.data;
            sum -= trail.data;
            lead = lead.next;
            trail = trail.next;
        }
        
        return sum;
    }
};

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna