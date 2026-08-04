class Solution
{
    public boolean isCycle(int V, int[][] edges) 
    {
        //Step 1: Define those edges in a adjacency list
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
            adj.get(v).add(u);
        }
        
        //Step 2: Traverse through all the unvisited vertices and perform dfs
        boolean[] visited = new boolean[V];
        for(int i=0;i<V;i++)
        {
            if(!visited[i])
            {
                if(dfs(i,-1,adj,visited))
                return true;
            }
        }
        return false;
    }
    private boolean dfs(int node,int parent,List<List<Integer>> adj,boolean[] visited)
    {
        if(visited[node])
        return false;
        
        visited[node]=true;
        
        //get the neighbors
        for(int neighbor:adj.get(node))
        {
            if(!visited[neighbor])
            {
                if(dfs(neighbor,node,adj,visited))
                return true;//cycle found
            }
            else
            {
                if(neighbor!=parent)
                {
                    return true;//cycle found
                }
            }
        }
        return false;
    }
}
