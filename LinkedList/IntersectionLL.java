/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    //Brute Force: Check each node in listA against listB -> O(N^2)
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) 
    {
        ListNode temp1 = headA;
        while(temp1!=null)
        {
            ListNode temp2 = headB;
            while(temp2!=null)
            {
                if(temp1==temp2)
                return temp1;
                temp2 = temp2.next;
            }
            temp1 = temp1.next;
        }
        return null;
    }
    //Better: Using HashSet
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) 
    {
        Set<ListNode> set = new HashSet<>();
        //Step 1: Add all the nodes in listA to Set
        ListNode temp = headA;
        while(temp!=null)
        {
            set.add(temp);
            temp = temp.next;
        }
        //Step 2: Add nodes in listB to Set and check if already present(intersection)
        temp = headB;
        while(temp!=null)
        {
            if(set.contains(temp))
            return temp;
            set.add(temp);
            temp = temp.next;
        }
        return null;
    }
    //Optimal: Using 2 pointer switching - both the pointers should be straight vartically to be intersected
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) 
    {
        ListNode temp1 = headA;
        ListNode temp2 = headB;

        while(temp1!=temp2)
        {
            temp1 = (temp1==null)?headB:temp1.next;
            temp2 = (temp2==null)?headA:temp2.next;
        }
        return temp1;
    }
}
