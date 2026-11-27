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
    public List<Integer> inorderTraversal1(TreeNode root) 
    {
        List<Integer> res = new ArrayList<>();
        traverse(root,res);
        return res;    
    }
    private void traverse(TreeNode node,List<Integer> res)
    {
        if(node==null)
        {
            return;
        }
        //left -> root -> right
        traverse(node.left,res);
        res.add(node.val);
        traverse(node.right,res);
    }

    //Iterative: Left - Root - Right
    //Step:
    // curr = root
    //1)Go to extreme left and keep adding to stack
    //2)Pop and add to list
    //3)curr = curr.right
    public List<Integer> inorderTraversal(TreeNode root) 
    {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> st = new ArrayDeque<>();

        if(root==null)
        return list;

        TreeNode curr = root;
        while(curr!=null||!st.isEmpty())
        {
            while(curr!=null)
            {
                st.push(curr);
                curr = curr.left;
            }

            curr = st.pop();
            list.add(curr.val);

            curr = curr.right;
        }
        return list;
    }
}
