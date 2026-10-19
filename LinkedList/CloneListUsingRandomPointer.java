/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    //Approach(1): Using a HashMap 
    public Node copyRandomList1(Node head) 
    {
        //Step 1: Create new nodes and add to map<original,clone>
        Map<Node,Node> map = new HashMap<>();
        Node original = head;
        while(original!=null)
        {
            Node clone = new Node(original.val);
            map.put(original,clone);
            original = original.next;
        }
        //Step 2: Traverse the list again and map the random and next clone nodes 
        original = head;
        while(original!=null)
        {
            //get the cloned node
            Node clone = map.get(original);
            //connect to random
            Node originalNext = original.next;
            Node originalRandom = original.random;
            //connect to next
            if(originalNext==null)
            {
                clone.next = null;
            }
            else
            {
                clone.next = map.get(originalNext);
            }
            //connect to random
            if(originalRandom==null)
            {
                clone.random = null;
            }
            else
            {
                clone.random = map.get(originalRandom);
            }
            original = original.next;
        }
        return map.get(head);
    }
    //Approach(2): By inserting the nodes in-between
    public Node copyRandomList(Node head) 
    {
        //Step 1: Create new node and insert inbetween
        Node temp = head;
        while(temp!=null)
        {
            Node newNode = new Node(temp.val);
            Node nextNode = temp.next;
            //connect(link + delink)
            temp.next = newNode;
            newNode.next = nextNode;

            temp = temp.next.next;//move 2 places since clone is placed inbetween
        }
        //Step 2: Connect the random pointers
        temp = head;
        while(temp!=null)
        {
            Node originalRandom = temp.random;
            Node clone = temp.next;
            if(originalRandom==null)
                clone.random = null;
            else
            {
                clone.random = originalRandom.next;
            }
            temp = temp.next.next;
        }
        //Step 3: Connect the next pointers(dummy)
        temp = head;
        Node dummy = new Node(-1);
        Node res = dummy;
        while(temp!=null)
        {
            res.next = temp.next;
            temp.next = temp.next.next;
            res = res.next;
            temp = temp.next;
        }
        return dummy.next;
    }
}
