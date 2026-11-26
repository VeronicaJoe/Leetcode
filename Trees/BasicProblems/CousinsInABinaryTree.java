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
 //Note: depth(x) == depth(y) && parent(x)!=parent(y) ==> COUSINS 
//Using BFS:
class Solution {
    public boolean isCousins(TreeNode root, int x, int y)
    {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        int depthX = -1 ,depthY = -1;
        int parentX = -1, parentY = -1;
        if(root==null)
        return false;

        q.offer(root);
        int level = 0;
        while(!q.isEmpty())
        {
            int size = q.size();
            level++;
            List<Integer> list = new ArrayList<>();

            for(int i=1;i<=size;i++)
            {
                TreeNode current = q.poll();
                list.add(current.val);
                //get the children
                if(current.left!=null)
                {
                    if(current.left.val==x)
                    {
                        parentX = current.val;
                        depthX = level;
                    }
                    else if(current.left.val==y)
                    {
                        parentY = current.val;
                        depthY = level;
                    }
                    q.offer(current.left);
                }
                if(current.right!=null)
                {
                    if(current.right.val==x)
                    {
                        parentX = current.val;
                        depthX = level;
                    }
                    else if(current.right.val==y)
                    {
                        parentY = current.val;
                        depthY = level;
                    }
                    q.offer(current.right);
                }
            }
            res.add(list);
        }

        if(depthX==-1||depthY==-1||parentX==-1||parentY==-1)
        return false;

        return (depthX==depthY&&parentX!=parentY);
    }
}
