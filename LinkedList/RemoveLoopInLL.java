/* Structure of Linked List Node
class Node {
    int data;
    Node next;
    Node(int val) {
        data = val;
        next = null;
    }
} */
class Solution {
    //Approach(1): Using Set
    public static void removeLoop1(Node head) {
        // code here
        Set<Node> set = new HashSet<>();
        Node temp = head;
        Node prev = null;
        while(temp!=null)
        {
            if(set.contains(temp))
            {
                prev.next = null;
                break;
            }
            set.add(temp);
            prev = temp;
            temp = temp.next;
        }
        
    }
    //Approach(2): Using tortoise and hare
    public static void removeLoop(Node head) 
    {
        //Step 1: Find is loop present
        Node slow = head;
        Node fast = head;
        boolean isCycle = false;
        
        while(fast!=null&&fast.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast)
            {
                isCycle = true;
                break;
            }
        }
        if(!isCycle)
        return;
        
        //Step 2: Starting point of a loop
        slow = head;
        while(slow!=fast)
        {
            slow = slow.next;
            fast = fast.next;
        }
        //Step 3: Remove the loop
        while(fast.next!=slow)
        {
            fast = fast.next;
        }
        fast.next = null;
    }
}
