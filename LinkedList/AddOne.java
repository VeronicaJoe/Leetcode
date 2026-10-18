/* Structure of linked list Node
class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}
*/
class Solution {
    //Brute Force: Reverse the List and Add Carry and Again reverse the list
    public Node addOne1(Node head) 
    {
        // code here.
        //Step (1): Reverse the list
        Node reversedHead = reverse(head);
        //Step (2): Traverse the list and add carry in each node(temp.val+carry)
        //          If carry==10 then carry = 1 and temp.val = 0
        //          else update temp.val = temp.val+carry
        Node temp = reversedHead;
        int carry = 1;
        while(temp!=null)
        {
            int sum = temp.data + carry;
            if(sum==10)
            {
                carry = 1;
                temp.data = 0;
            }
            else
            {
                carry = 0;
                temp.data = sum;
            }
            temp = temp.next;
        }
        //Step (3): Reverse the list 
        Node finalList = reverse(reversedHead);
        //Edge case: if carry = 1 then create a newNode(1) and append to the head and new head will be the head
        if(carry!=0)
        {
            Node newNode = new Node(carry);
            newNode.next = finalList;
            return newNode;
        }
        return finalList;
    }
    private Node reverse(Node head)
    {
        //Base Case:
        if(head==null||head.next==null)
        return head;
        
        //Recursive Case:
        Node newHead = reverse(head.next);//doesnt change
        Node front = head.next;
        front.next = head;
        head.next = null;
        
        return newHead;
    }
    //Recursive: Without using reverse() and using backtracking
    private int addOneUtil(Node head)
    {
        //base case:
        if(head==null)
        return 1;
        
        //recursive
        int carry = addOneUtil(head.next);
        int sum = carry+head.data;
        head.data = sum%10;
        return sum/10;
    }
    public Node addOne(Node head) 
    {
        int carry = addOneUtil(head);
        if(carry!=0)
        {
            Node newNode = new Node(carry);
            newNode.next = head;
            return newNode;
        }
        return head;
    }
}
