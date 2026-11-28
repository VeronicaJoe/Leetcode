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
    public int maxDepth(TreeNode root) 
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
}
