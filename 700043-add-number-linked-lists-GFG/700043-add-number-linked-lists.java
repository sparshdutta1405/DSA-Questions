/*
class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}
*/

class Solution {
    public Node addTwoLists(Node num1, Node num2) {
        // code here
        num1 = trimLeadingZeros(num1);
        num2 = trimLeadingZeros(num2);
        
        num1 = reverse(num1);
        num2 = reverse(num2);
        
        Node dummy = new Node(0);
        Node current = dummy;
        int carry = 0;
        
        
        while(num1 != null || num2 != null || carry != 0){
            int sum = carry;
            
            if(num1 != null){
                sum += num1.data;
                num1 = num1.next;
            }
            
            if(num2 != null){
                sum += num2.data;
                num2 = num2.next;
            }
            
            
            carry = sum/10;
            current.next = new Node(sum % 10);
            current = current.next;
        }
        
        Node result = reverse(dummy.next);
        
        return trimLeadingZeros(result);
    }
    
    private static Node trimLeadingZeros(Node head){
        while(head != null && head.data == 0 && head.next != null){
            head = head.next;
        }
        
        return head;
    }
    
    private static Node reverse(Node head){
        Node prev = null;
        Node current = head;
        
        while(current != null){
            Node nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        
        return prev;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna