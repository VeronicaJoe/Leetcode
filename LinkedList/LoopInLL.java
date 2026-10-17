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
    public boolean hasCycle1(ListNode head) 
    {
        if(head==null||head.next==null)
        return false;
        Set<ListNode> set = new HashSet<>();
        ListNode temp = head;
        while(temp!=null)
        {
            if(set.contains(temp))
            return true;
            set.add(temp);
            temp = temp.next;
        }
        return false;
    }
    //Approach(2): Using slow and fast ptr(Tortoise and Hare algorithm)
    public boolean hasCycle(ListNode head) 
    {
        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null&&fast.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast)
            return true;
        }
        return false;
    }
}
