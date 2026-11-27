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
    //Iterative: root - left - right
    //DS: Stack: root - right - left (becoz LIFO unline Queue)
    public List<Integer> preorderTraversal(TreeNode root)
    {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> st = new ArrayDeque<>();

        if(root==null)
        return list;

        st.push(root);
        while(!st.isEmpty())
        {
            TreeNode curr = st.pop();
            list.add(curr.val);
            if(curr.right!=null)
            {
                st.push(curr.right);
            }
            if(curr.left!=null)
            {
                st.push(curr.left);
            }
        }
        return list;
    } 
}
