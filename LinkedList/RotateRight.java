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
    public ListNode rotateRight(ListNode head, int k) 
    {
        //Edge Case: 
        if(head==null||head.next==null||k<=0)
        {
            return head;
        }    

        //Step 1: Find no of nodes and find the tail node
        ListNode tail = head;
        int length = 1;//for head;
        while(tail.next!=null)
        {
            tail = tail.next;
            length++;
        }

        //Step 2: Find the newTail = n-kth node
        k = k%length;//reduce the rotations
        if(k<=0)
        {
            return head;
        }

        int steps = length-k;
        ListNode newTail = head;
        for(int i=1;i<steps;i++)
        {
            newTail = newTail.next;
        }

        //Step 3: Find newHead = n-k+1
        ListNode newHead = newTail.next;

        //Connect:
        tail.next = head;
        newTail.next = null;
        head = newHead;

        return head;
    }
}
