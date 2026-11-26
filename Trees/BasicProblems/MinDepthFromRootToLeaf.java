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
    //Using BFS:
    //          Modification: if the child node(left and right -> null) 
    //                          the update the minDepth = min(minDepth,level)
    public int minDepth(TreeNode root) 
    {
        // List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        int minDepth = Integer.MAX_VALUE;
        int level = 0;
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

                if(curr.left==null&&curr.right==null)
                {
                    //leaf node - update minDepth
                    minDepth = Math.min(minDepth,level);
                    break;
                }
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
        return minDepth;
    }
}
