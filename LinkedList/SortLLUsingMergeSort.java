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
    //Brute Force: Traverse and store all the node values in a list and sort it
    //             Traverse list and update the list
    public ListNode sortList1(ListNode head) 
    {    
        //Step 1: Store in list + sort
        List<Integer> ls = new ArrayList<>();
        ListNode temp = head;
        while(temp!=null)
        {
            ls.add(temp.val);
            temp = temp.next;
        }
        Collections.sort(ls);
        //Step 2: Update LL
        temp = head;
        int i=0;
        while(temp!=null)
        {
            temp.val = ls.get(i);
            i++;
            temp = temp.next;
        }
        return head;
    }
    //Optimal Approach: Using Merge Sort(divide and conquer)
    //                  1)Keep diving the list till single element(Find middle in a LL)
    //                  2)Backtrack - Merge 2 LL
    public ListNode sortList(ListNode head) 
    {
        return mergeSort(head);
    }
    private ListNode mergeSort(ListNode head)
    {
        //base case: single node
        if(head==null||head.next==null)
        return head;

        //Find the middle
        ListNode middle = middleNode(head);
        ListNode list1Head = head;
        ListNode list2Head = middle.next;
        middle.next = null;
        //recursive
        ListNode head1 = mergeSort(list1Head);
        ListNode head2 = mergeSort(list2Head);

        return mergeTwoList(head1,head2);
    }
    private ListNode middleNode(ListNode head)
    {
        ListNode slow = head;
        ListNode fast = head;
        //make it balanced for even length list(take the 1st middle node instead of 2nd middle node)
        while(fast.next!=null&&fast.next.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    private ListNode mergeTwoList(ListNode head1,ListNode head2)
    {
        if(head1==null&&head2==null)
        return null;

        if(head1==null&&head2!=null)
        return head2;

        if(head1!=null&&head2==null)
        return head1;

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        ListNode temp1 = head1;
        ListNode temp2 = head2;

        while(temp1!=null&&temp2!=null)
        {
            if(temp1.val<temp2.val)
            {
                curr.next = temp1;
                curr = temp1;
                temp1 = temp1.next;
            }
            else
            {
                curr.next = temp2;
                curr = temp2;
                temp2 = temp2.next;
            }
        }
        curr.next = (temp1==null)?temp2:temp1;

        return dummy.next;
    }
}
