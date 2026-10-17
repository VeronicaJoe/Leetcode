/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    //Approach(1): Using HashSet
    public ListNode detectCycle1(ListNode head) 
    {
        Set<ListNode> set = new HashSet<>();
        ListNode temp = head;
        while(temp!=null)
        {
            if(set.contains(temp))
            return temp;
            set.add(temp);
            temp = temp.next;
        }
        return null;
    }
    //Approach(2): Using Tortoise and Hare
    public ListNode detectCycle(ListNode head)
    {
        //Step 1: Check is loop present
        ListNode slow = head;
        ListNode fast = head;
        boolean isCycle = false;
        while(fast!=null&&fast.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;

            if(slow==fast)
            {
                isCycle = true;
                break;
            }
        }
        if(!isCycle)
        return null;

        //Step 2: Find the starting point
        slow = head;
        while(slow!=fast)
        {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;//or return fast;
    }

}
