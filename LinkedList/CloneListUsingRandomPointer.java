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
    //Approach (1): Using Hashmap
    public Node copyRandomList1(Node head) 
    {
        Map<Node,Node> map = new HashMap<>();
        //Step 1: Create new nodes and store in map<original,copy>
        Node temp = head;
        while(temp!=null)
        {
            Node newNode = new Node(temp.val);
            map.put(temp,newNode);
            temp = temp.next;
        }

        //Step 2: Again traverse through original list and get the clone from the map
        temp = head;
        while(temp!=null)
        {
            Node copy = map.get(temp);
            //next
            copy.next = map.get(temp.next);
            //random
            copy.random = map.get(temp.random);
            temp = temp.next;
        }
        return map.get(head);
    }

    // TC: O(N) SC: O(N)+O(N) 

    //Approach(2): Without Using HashMap
    public Node copyRandomList(Node head) 
    {
        if(head==null)
        return null;
        //Step 1: Create new nodes and insert inbetween
        Node temp = head;
        while(temp!=null)
        {
            Node newNode = new Node(temp.val);
            Node nextNode = temp.next;
            //connect: temp(original) -> newNode -> nextNode
            temp.next = newNode;
            newNode.next = nextNode;

            temp = nextNode;//2 steps , if 1 step used will land in copy
        }

        //Step 2: Connect Random ptrs
        temp = head;
        while(temp!=null)
        {
            Node copy = temp.next;
            Node originalRandom = temp.random;
            if(originalRandom==null)
            {
                copy.random = null;
            }
            else
            {
                copy.random = originalRandom.next;
            }
            temp = temp.next.next;
        }

        //Step 3: Connect next but extract the copy list using a dummy node approach
        Node dummy = new Node(-1);
        Node res = dummy;
        temp = head;
        while(temp!=null)
        {
            res.next = temp.next;//copy
            temp.next = temp.next.next;//original

            res = res.next;
            temp = temp.next;
        }
        return dummy.next;
    }
}
