/* Structure of Doubly Linked List Node
class Node {
    public int data;
    public Node next;
    public Node prev;

    public Node(int val) {
        data = val;
        next = null;
        prev = null;
    }
}; */

class Solution {
    //Brute Force: Check all combinations
    public ArrayList<ArrayList<Integer>> givenSumPairs1(Node head, int target) 
    {
        // code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for(Node i=head;i!=null;i=i.next)
        {
            for(Node j=i.next;j!=null;j=j.next)
            {
                if(i.data+j.data==target)
                {
                    ArrayList<Integer> pair = new ArrayList<>();
                    pair.add(i.data);
                    pair.add(j.data);
                    res.add(pair);
                }
            }
        }
        return res;
    }
    //Optimal: Using 2 pointer(2 sum)
    public ArrayList<ArrayList<Integer>> givenSumPairs(Node head, int target) 
    {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Node left = head;
        Node right = head;
        while(right.next!=null)
        {
            right = right.next;
        }
        
        while(left!=null&&right!=null&&left!=right&&right.next!=left)
        {
            int sum = left.data+right.data;
            if(sum==target)
            {
                ArrayList<Integer> pair = new ArrayList<>();
                pair.add(left.data);
                pair.add(right.data);
                res.add(pair);
                left = left.next;
                right = right.prev;
            }
            else if(sum<target)
            {
                left = left.next;
            }
            else
            {
                right = right.prev;
            }
        }
        return res;
    }
}
