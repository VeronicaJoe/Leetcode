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
    //Brute Force: Use ArrayList
    public ListNode oddEvenList1(ListNode head) 
    {
        //Step 1: Store all node values in ArrayList
        List<Integer> list = new ArrayList<>();
        ListNode temp = head;
        while(temp!=null)
        {
            list.add(temp.val);
            temp = temp.next;
        }
        //Step 2: Modify the linked list values
        //        (a) Even Index -> Odd pos
        //        (b) Odd Index -> Even pos    
        int n = list.size();
        //Odd Pos
        temp = head;
        for(int i=0;i<n;i+=2)
        {
            temp.val = list.get(i);
            temp = temp.next;
        }
        //Even Pos
        for(int i=1;i<n;i+=2)
        {
            temp.val = list.get(i);
            temp = temp.next;
        }
        return head;
    }
    //Optimal: Using 2 dummy list
    public ListNode oddEvenList(ListNode head) 
    {
        if(head==null||head.next==null)
        return head;

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;
        while(even!=null&&even.next!=null)
        {
            odd.next = even.next;
            odd = odd.next;

            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;//connect both the list
        return head;
    }
}
