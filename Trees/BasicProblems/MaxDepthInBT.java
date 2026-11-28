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
     //Iterative Approach: Using BFS(level order traversal)
    public int maxDepth1(TreeNode root) 
    {
        int level = 0;
        Deque<TreeNode> q = new ArrayDeque<>();

        if(root==null)
        return 0;

        q.offer(root);
        while(!q.isEmpty())
        {
            int size = q.size();
            level++;
            for(int i=1;i<=size;i++)
            {
                TreeNode curr = q.poll();
                if(curr.left!=null)
                {
                    q.offer(curr.left);
                }
                if(curr.right!=null)
                {
                    q.offer(curr.right);
                }
            }
        }
        return level;
    }
    //Recursive: Using DFS - My Code :) Hehee
    public int maxDepth2(TreeNode root) 
    {
        if(root==null)
            return 0;
        int dep = 0;
        return helper(root,dep);
    }
    private int helper(TreeNode node,int dep)
    {
        if(node==null)
        {
            return dep;
        }
        return Math.max(helper(node.left,dep+1),helper(node.right,dep+1));
    }
    //Recursive: Using DFE: Std Interview Code
    public int maxDepth(TreeNode root) 
    {
        return findMaxDepth(root);
    }
    private int findMaxDepth(TreeNode node)
    {
        if(node==null)
        return 0;

        int left = findMaxDepth(node.left);
        int right = findMaxDepth(node.right);

        return 1+Math.max(left,right);//1-> curr node
    }
}
