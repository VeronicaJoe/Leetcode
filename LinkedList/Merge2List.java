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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) 
    {
        if(list1==null&&list2==null)
        return null;
        if(list1==null&&list2!=null)
        {
            return list2;
        }
        if(list1!=null&&list2==null)
        {
            return list1;
        }

        ListNode res = new ListNode(-1);
        ListNode temp = res;
        while(list1!=null&&list2!=null)
        {
            //compare the values
            ListNode newNode;
            if(list1.val<list2.val)
            {
                newNode = new ListNode(list1.val);
                list1 = list1.next;
                
            }
            else//list1.val>=list2.val
            {
                newNode = new ListNode(list2.val);
                list2 = list2.next;
            }
            temp.next = newNode;
            temp = newNode;
        }    

        temp.next = (list1==null)?list2:list1;
        return res.next;
    }
}
