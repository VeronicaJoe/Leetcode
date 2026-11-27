/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    //Iterative: left - right - root
    //Using 2 stack: 
    //              Push node -> st1
    //              Pop and push to st2
    //              Get left and right child and push to st1
    //              Perform till st1 becomes empty
    //              Pop all values from st2 -> list
    public List<Integer> postorderTraversal(TreeNode root)
    {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> st1 = new ArrayDeque<>();
        Deque<Integer> st2 = new ArrayDeque<>();

        if(root==null)
        return list;

        st1.push(root);
        while(!st1.isEmpty())
        {
            TreeNode curr = st1.pop();
            st2.push(curr.val);

            //left
            if(curr.left!=null)
            {
                st1.push(curr.left);
            }
            //right
            if(curr.right!=null)
            {
                st1.push(curr.right);
            }
        }
        //pop from st2 and add to list
        while(!st2.isEmpty())
        {
            list.add(st2.pop());
        }
        return list;
    }
}
