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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k <= 0)
            return head;

        ListNode temp = head;
        ListNode prevNode = null;

        while (temp != null) {
            //Step 1: Find the kth Node
            ListNode kthNode = findKthNode(temp, k);
            if (kthNode != null) {
                //preserve the next node
                ListNode nextNode = kthNode.next;
                kthNode.next = null;
                reverse1(temp);
                if (head == temp) {
                    head = kthNode;
                } else {
                    //connect
                    if (prevNode != null) {
                        prevNode.next = kthNode;
                    }
                }
                prevNode = temp;
                temp = nextNode;
            } else {
                prevNode.next = temp;
                break;
            }
        }
        return head;
    }
    //Do not use - stack (in-place changes the value - restricted in desc)
    private ListNode reverse1(ListNode head) {
        // prev <- curr <- next
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    private ListNode findKthNode(ListNode head, int k) {
        ListNode temp = head;
        int cnt = 1;
        while (temp.next != null && cnt != k) {
            temp = temp.next;
            cnt++;
        }
        return (cnt != k) ? null : temp;//kth
    }

}
