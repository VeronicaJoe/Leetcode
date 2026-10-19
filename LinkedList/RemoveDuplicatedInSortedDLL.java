/* Structure of a link list node
class Node {
    int data;  // value stored in node
    Node next;
    Node prev;

    Node(int value) {
        data = value;
        next = null;
        prev = null;
    }
}
*/
class Solution {
    //Brute Force: Compare each next node with the current node
    Node removeDuplicates1(Node headRef) 
    {
        // code here
        Node temp1 = headRef;
        while(temp1!=null)
        {
            Node temp2 = temp1.next;
            while(temp2!=null)
            {
                if(temp1.data == temp2.data)
                {
                    Node nextNode = temp2.next;
                    temp1.next = nextNode;
                    if(nextNode!=null)
                    nextNode.prev = temp1;
                    temp2 = nextNode;
                }
                else
                {
                    temp2 = temp2.next;
                }
                // temp2 = temp2.next;
            }
            temp1 = temp1.next;
        }
        return headRef;
    }
    //Optimal: Since the LL is sorted compare curr with next node
    Node removeDuplicates(Node headRef)
    {
        Node curr = headRef;
        while(curr!=null&&curr.next!=null)
        {
            //duplicate
            if(curr.data==curr.next.data)
            {
                
                Node newNext = curr.next.next;
                curr.next = newNext;
                if(newNext!=null)
                newNext.prev = curr;
            }
            else
            {
                curr = curr.next;
            }
        }
        return headRef;
    }
}
