class Solution 
{
    int timer = 0;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) 
    {
        List<List<Integer>> res = new ArrayList<>();//contains critical edges
        //Step 1: Adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(List<Integer> connection:connections)
        {
            int u = connection.get(0);
            int v = connection.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);//make undirected -> directed
        }

        //Step 2: Perform DFS
        boolean[] visited = new boolean[n];
        int parent = -1;//for node 1

        int[] tin = new int[n];//time of insertion - maintain timer globally
        int[] low = new int[n];//low-link level - initially 1st time it will have same value as tin and on backtracking might change
        for(int i=0;i<n;i++)
        {
           if(!visited[i])
            {
                dfs(i,parent,adj,visited,tin,low,res);//Single DFS
            }
        }
        return res;
    }
    private void dfs(int node,int parent,List<List<Integer>> adj,boolean[] visited,int[] tin,int[] low,List<List<Integer>> res)
    {
        //base case
        if(visited[node])
        return;

        visited[node] = true;
        tin[node] = low[node] = ++timer;
        //get the neighbors
        for(int neighbor:adj.get(node))
        {
            //now node -> parent and neighbor -> child
            if(neighbor==parent)
            continue;
        
            if(!visited[neighbor])
            {
                dfs(neighbor,node,adj,visited,tin,low,res);
                //Step (a): Get the min low-link from adj except from parent
                low[node] = Math.min(low[node],low[neighbor]);
                //Step (b): Check if its a bridge
                if(low[neighbor]>tin[node])
                {
                    //BRIDGE!
                    res.add(Arrays.asList(node,neighbor));
                }
            }
            else
            {
                //neighbor already visited- it has both low and tin but the low for node and neighbor will be same as it is a back edge 
                //backedge
                //Step (a): Get the min low-link from adj except from parent
                low[node] = Math.min(low[node],low[neighbor]);
                // low[node] = Math.min(low[node],tin[neighbor]); -  Standard
            }   
        }
    }
}
