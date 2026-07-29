class Solution {
    boolean graphColoring(int v, int[][] edges, int m) {
        // code here
        int[] color = new int[v];
        return generate(0,v,m,edges,color);
    }
    private boolean generate(int node,int v,int m,int[][] edges,int[] color)
    {
        //base case
        if(node==v)
        return true;
        
        //for loop backtracking
        for(int currColor=1;currColor<=m;currColor++)
        {
            if(isSafe(node,currColor,edges,color))
            {
                //assign
                color[node]=currColor;
                //move to next node
                if(generate(node+1,v,m,edges,color))
                return true;
                //backtrack
                color[node]=0;
            }
        }
        return false;
    }
    private boolean isSafe(int node,int nodeColor,int[][] edges,int[] color)
    {
        for(int[] edge:edges)
        {
            int u = edge[0];
            int v = edge[1];
            
            if(node==u&&color[v]==nodeColor)
            {
                return false;
            }
            if(node==v&&color[u]==nodeColor)
            {
                return false;
            }
        }
        return true;
    }
}
