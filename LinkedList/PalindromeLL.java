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
    //Brute Force: Using Stack
    public boolean isPalindrome1(ListNode head) 
    {
        Deque<Integer> dq = new ArrayDeque<>();
        ListNode temp = head;
        while(temp!=null)
        {
            dq.push(temp.val);
            temp = temp.next;
        }

        temp = head;
        while(temp!=null)
        {
            if(temp.val!=dq.pop())
            return false;
            temp = temp.next;
        }
        return true;
    }
    //Better: Using Stack for comparison and Tortoise and Hare for finding middle node
    public boolean isPalindrome2(ListNode head) 
    {
        //Step 1: Find Middle Node and half nodes to stack
        ListNode slow = head;
        ListNode fast = head;
        Deque<Integer> dq = new ArrayDeque<>();
        while(fast!=null&&fast.next!=null)
        {
            dq.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }
        //slow  - middle
        //If Odd length skip the middle element for comparison - Edge Case
        if(fast!=null&&fast.next==null)
        {
            slow = slow.next;
        }
        //Step 2:Compare nodes with stack
        while(slow!=null)
        {
            if(slow.val!=dq.pop())
            {
                return false;
            }
            slow = slow.next;
        }
        return true;
    }
    public boolean isPalindrome(ListNode head) 
    {
        //Step 1: Find the Middle Node
        ListNode slow = head;
        ListNode fast = head;
        ListNode prevNode = null;

        while(fast!=null&&fast.next!=null)
        {
            prevNode = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        //Step 2: Reverse the second half
        if(prevNode!=null)
        prevNode.next = null;
        //Edge Case: skip the middle node if odd length
        if(fast!=null&&fast.next==null)
        slow = slow.next;
        ListNode head2 = reverseList(slow);
        //Step 3: Compare both the list
        ListNode temp1 = head;
        ListNode temp2 = head2;
        while(temp1!=null&&temp2!=null)
        {
            if(temp1.val!=temp2.val)
            return false;

            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return true;
    }
    private ListNode reverseList(ListNode head)
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
