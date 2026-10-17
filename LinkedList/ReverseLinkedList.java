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
    //Approach(1): Use a stack
    public ListNode reverseList1(ListNode head) 
    {
        Deque<Integer> dq = new ArrayDeque<>();
        ListNode temp = head;
        while(temp!=null)
        {
            dq.push(temp.val);
            temp = temp.next;
        }
        temp = head;
        while(!dq.isEmpty())
        {
            temp.val = dq.pop();
            temp = temp.next;
        }
        return head;
    }
    //Approach(2):
    //Before: back -> curr -> front
    //After: back <- curr <- front 
    public ListNode reverseList2(ListNode head) 
    {
        ListNode curr = head;
        ListNode back = null;
        while(curr!=null)
        {
            ListNode front = curr.next;
            curr.next = back;
            back = curr;
            curr = front;
        }
        return back;
    }
    public ListNode reverseList(ListNode head) 
    {
        if(head==null||head.next==null)
        return head;

        ListNode newHead = reverseList(head.next);
        ListNode front = head.next;
        front.next = head;
        head.next = null;

        return newHead;
    }
}
