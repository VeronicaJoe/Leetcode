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
    //Approach(1): Brute Force (cnt and remove)
    public ListNode deleteMiddle1(ListNode head) 
    {
        if(head==null||head.next==null)
        return null;
        //Step 1: Count length of LL
        int cnt = 0;
        ListNode temp = head;
        while(temp!=null)
        {
            cnt++;
            temp = temp.next;
        }
        //Step 2: Find Middle
        int middle = cnt/2;//floor
        //Step 3: Remove Middle 
        temp = head;
        middle = middle-1;
        while(middle>0)
        {
            middle--;
            temp = temp.next;
        }   
        temp.next = temp.next.next;
        return head;
    }
    //Approach(2): Using Tortoise and Hare
    public ListNode deleteMiddle(ListNode head) 
    {
        if(head==null||head.next==null)
        return null;
        ListNode slow = head;
        ListNode fast = head.next.next;
        while(fast!=null&&fast.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
