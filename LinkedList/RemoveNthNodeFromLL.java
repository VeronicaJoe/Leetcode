/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    //Brute Force: 
    //           Count length of list
    //           Removal: Connect (len - n) node to n.next node
    public ListNode removeNthFromEnd1(ListNode head, int n) 
    {
        //Step 1: Length of LL
        ListNode temp = head;
        int len = 0;
        while(temp!=null)
        {
            len++;
            temp = temp.next;
        }
        //Step 2: Len - n connect to n.next
        int pos = len - n;
        //Edge Case: Delete Head
        if(pos==0)
        return head.next;

        temp = head;
        for(int i=1;i<pos;i++)
        {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return head;
    }
    //Optimal: Using Tortoise and Hare
    //         1)Keep slow and fast -> head
    //         2)Move fast -> n steps ahead
    //         3)Move slow and fast one by one (stop when fast.next==null)
    public ListNode removeNthFromEnd(ListNode head, int n) 
    {
        ListNode slow = head;
        ListNode fast = head;

        //Step 1:Move fast -> n steps ahead
        while(n>0)
        {
            fast = fast.next;
            n--;
        }
        if(fast==null)
        return head.next;
        //Step 2:Move slow and fast one by one (stop when fast.next==null)
        while(fast.next!=null)
        {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
