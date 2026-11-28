//Intution:
//          If(state == 1) -> add to Preorder, state++, if left present add to st 
//          else If(state == 2) -> add to Inorder, state++, if right present add to st 
//          else -> add to Postorder
import java.util.*;
public class Solution {
    static class Pair
    {
        TreeNode node;
        int state;

        public Pair(TreeNode node,int state)
        {
            this.node = node;
            this.state = state;
        }
    }
    public static List<List<Integer>> getTreeTraversal(TreeNode root) 
    {
        //your code goes here
        Deque<Pair> st = new ArrayDeque<>();
        List<Integer> inorder = new ArrayList<>();
        List<Integer> preorder = new ArrayList<>();
        List<Integer> postorder = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();

        if(root==null)
        return res;

        st.push(new Pair(root,1));
        while(!st.isEmpty())
        {
            Pair pair = st.pop();
            TreeNode curr = pair.node;
            int state = pair.state;

            if(state==1)
            {
                preorder.add(curr.data);
                state = state+1;
                st.push(new Pair(curr,state));
                if(curr.left!=null)
                {
                    st.push(new Pair(curr.left,1));
                }
            }
            else if(state==2)
            {
                inorder.add(curr.data);
                state = state+1;
                st.push(new Pair(curr,state));
                if(curr.right!=null)
                {
                    st.push(new Pair(curr.right,1));
                }
            }
            else
            {
                postorder.add(curr.data);
            }
        }
        res.add(inorder);
        res.add(preorder);
        res.add(postorder);
        return res;
    }
}
