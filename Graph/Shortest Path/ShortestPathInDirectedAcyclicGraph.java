class Solution {
    public ArrayList<Integer> shortestPath(int V, int[][] edges) 
    {
        // Code here
        
        //Step 1: Perform Topo Sort
    
        //i) Build Adj list
        //0->{{2,1},{3,6}} -> list of list with node and weight
        List<List<int[]>> adj = new ArrayList<>();
        
        for(int i=0;i<V;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int[] edge:edges)
        {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            
            adj.get(u).add(new int[]{v,wt});//directed graph
        }
        //ii) Perform DFS - topo sort
        Stack<Integer> st = new Stack<>();
        boolean[] visited = new boolean[V];
        for(int i=0;i<V;i++)
        {
            if(!visited[i])
            {
                dfs(i,visited,adj,st);
            }
        }
        
        //Step 2: Pop out till u get a src = 0
        while(!st.isEmpty())
        {
            if(st.peek()==0)
            break;
            
            st.pop();
        }
        //Step 3: Create dist[]
        int[] dist = new int[V];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[0] = 0;
        
        while(!st.isEmpty())
        {
            int nodeVal = st.pop();
            if(dist[nodeVal]==Integer.MAX_VALUE)
            continue;
            int nodeWeight = dist[nodeVal];
            //get the neighbor
            for(int[] neighbor:adj.get(nodeVal))
            {
                int neighborVal = neighbor[0];
                int neighborWeight = nodeWeight+neighbor[1];
                if(neighborWeight<dist[neighborVal])
                {
                    dist[neighborVal]=neighborWeight;
                }
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=0;i<V;i++)
        {
            int val = dist[i]==Integer.MAX_VALUE?-1:dist[i];
            res.add(val);
        }
        return res;
    }
    private void dfs(int node,boolean[] visited,List<List<int[]>> adj,Stack<Integer> st)
    {
        visited[node]=true;
        //get neighbor
        for(int[] neighbor:adj.get(node))
        {
            int neighborVal = neighbor[0];
            int neighborWeight = neighbor[1];
            
            if(!visited[neighborVal])
            dfs(neighborVal,visited,adj,st);
        }
        //add to stack
        st.push(node);
    }
}
