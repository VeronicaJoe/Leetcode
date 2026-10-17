/* Structure of Linked List Node
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}*/

class Solution {
    //Approach(1): Using Set
    public int lengthOfLoop1(Node head) 
    {
        Set<Node> set = new HashSet<>();
        Node temp = head;
        boolean isCycle = false;
        Node loopStart = null;
        while(temp!=null)
        {
            if(set.contains(temp))
            {
                loopStart = temp;
                isCycle = true;
                break;//loop
            }
            set.add(temp);
            temp = temp.next;
        }
        if(!isCycle)
        return 0;
        
        int cnt = 1;
        
        while(temp.next!=loopStart)
        {
            cnt++;
            temp = temp.next;
        }
        return cnt;
    }
    //Approach(2): Using Tortoise and Hare
    public int lengthOfLoop(Node head) {
        // code here
        //Step 1: Check if loop present
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
        return 0;
        //Step 2: Find starting point of loop
        slow = head;
        while(slow!=fast)
        {
            slow = slow.next;
            fast = fast.next;
        }
        //Step 3: Cnt nodes in the loop
        int cnt = 1;
        while(fast.next!=slow)
        {
            cnt++;
            fast = fast.next;
        }
        return cnt;
    }
}
