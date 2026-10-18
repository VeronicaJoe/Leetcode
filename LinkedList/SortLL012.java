/*
class Node {
    int data;
    Node next;

    Node(int d)
    {
        data = d;
        next = null;
    }
}*/

class Solution {
    //Brute Force: Count Nodes (0,1,2) and update the list
    public Node segregate1(Node head) 
    {
        //Step 1: Count
        int cnt0 = 0, cnt1 = 0, cnt2 = 0;
        Node temp = head;
        while(temp!=null)
        {
            if(temp.data==0)
            cnt0++;
            else if(temp.data==1)
            cnt1++;
            else
            cnt2++;
            
            temp = temp.next;
        }
        //Step 2: Update LL
        temp = head;

        while(cnt0>0)
        {
            temp.data = 0;
            temp = temp.next;
            cnt0--;
        }
        while(cnt1>0)
        {
            temp.data = 1;
            temp = temp.next;
            cnt1--;
        }
        while(cnt2>0)
        {
            temp.data = 2;
            temp = temp.next;
            cnt2--;
        }
        return head;
    }
    //Optimal: Use 3 dummy list (0,1,2)
    public Node segregate(Node head) 
    {
        Node zeroList = new Node(-1);
        Node zeroHead = zeroList;
        Node oneList = new Node(-1);
        Node oneHead = oneList;
        Node twoList = new Node(-1);
        Node twoHead = twoList;
        
        Node temp = head;
        
        //Step 1: Create 3 list(0,1,2)
        while(temp!=null)
        {
            if(temp.data==0)
            {
                zeroList.next = temp;
                zeroList = temp;
            }
            else if(temp.data==1)
            {
                oneList.next = temp;
                oneList = temp;
            }
            else
            {
                twoList.next = temp;
                twoList = temp;
            }
            temp = temp.next;
        }
        //Step 2: Connect the list
        
        zeroList.next = (oneHead.next!=null)?oneHead.next:twoHead.next;
        oneList.next = twoHead.next;
        twoList.next = null;
        
        return zeroHead.next;
        
    }
}
