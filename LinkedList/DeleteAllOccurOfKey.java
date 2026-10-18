/*Structure of the doubly linked list  Node
class Node {
  public int data;
  public Node next;
  public Node prev;

  public Node(int x) {
      data = x;
      next = null;
      prev = null;
  }
};*/

class Solution {
    //Brute Force: If key found perform linking and unlinking
    public Node deleteAllOccurOfX(Node head, int x) 
    {
        // code here
        Node temp = head;
        while(temp!=null)
        {
            if(temp.data==x)
            {
                if(temp==head)
                head = head.next;//head should not be key
                Node prevNode = temp.prev;
                Node nextNode = temp.next;
                if(prevNode!=null)
                {
                    prevNode.next = nextNode;
                }
                if(nextNode!=null)
                {
                    nextNode.prev = prevNode;
                }
                temp.next = null;
                temp.prev = null;
                temp = nextNode;
            }
            else
            {
                temp = temp.next;
            }
        }
        return head;
    }
}
