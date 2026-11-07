/*
class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}*/

class Solution {
    public boolean isPalindrome(Node head) {
        // code here
        
        if(head == null || head.next == null)
        return true;
        
        
        Node slow = head;
        Node fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        Node secondHalfHead = reverseList(slow.next);
        
        Node first = head;
        Node second = secondHalfHead;
        boolean result = true;
        
        while(second != null){
            if(first.data != second.data){
                result = false;
                break;
            }
            
            first = first.next;
            second = second.next;
        }
        
        // slow.next = reverseList(secondHalfHead); This is restore the original list
        return result;
        
        
        
    }
    
    private Node reverseList(Node head){
        Node prev = null;
        Node current = head;
        
        while(current != null){
            Node nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        
        return prev ;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna