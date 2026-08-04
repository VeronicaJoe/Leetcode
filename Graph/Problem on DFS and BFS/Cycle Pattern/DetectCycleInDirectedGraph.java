class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        //[u,v] -> u->v
        
        //Step 1: Determine adjacent list
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++)
        {
            adj.add(new ArrayList<>());
        }
        
        for(int[] edge:edges)
        {
            int u = edge[0];
            int v = edge[1];
            
            adj.get(u).add(v);
        }
        
        //Step 2: Traverse throught all the connected components which are not visited
        boolean[] vis = new boolean[V];
        boolean[] pathVis = new boolean[V];
        for(int i=0;i<V;i++)
        {
            if(!vis[i])
            {
                if(dfs(i,adj,vis,pathVis))
                return true;
            }
        }
        return false;
    }
    private boolean dfs(int node,List<List<Integer>> adj,boolean[] vis,boolean[] pathVis)
    {
        vis[node]=true;
        pathVis[node]=true;
        
        //get the neighbors
        for(int neighbor:adj.get(node))
        {
            //node not visited yet
            if(!vis[neighbor])
            {
                if(dfs(neighbor,adj,vis,pathVis))
                return true;
            }
            else
            {
                //node should be visited in the same path again - cycle
                if(pathVis[neighbor])
                {
                    return true;
                }
                
            }
        }
        //backtrack
        pathVis[node]=false;
        return false;
    }
}
