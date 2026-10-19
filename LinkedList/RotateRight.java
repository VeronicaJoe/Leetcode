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
        if(head==null||head.next==null||k<0)
        return head;
        //Step 1: Find length and tail
        ListNode tail = head;
        int len = 1;
        while(tail.next!=null)
        {
            len++;
            tail = tail.next;
        }
        //Edge Case: No rotations
        k = k%len;
        if(k==0)
        return head;
        //Step 2:Find len-k node
        int cnt = len-k-1;
        ListNode beforeHead = head;
        while(cnt>0)
        {
            beforeHead = beforeHead.next;
            cnt--;
        }
        ListNode newHead = beforeHead.next;
        beforeHead.next = null;
        tail.next = head;
        return newHead;
    }
}
