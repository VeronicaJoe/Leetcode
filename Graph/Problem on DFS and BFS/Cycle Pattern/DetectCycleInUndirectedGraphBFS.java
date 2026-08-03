class Solution {
    public boolean isCycle(int V, int[][] edges) 
    {
        // Code here
        //Step 1: Define the adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++)
        {
            adj.add(new ArrayList<>());
        }
        
        for(int[] edge:edges)
        {
            int node1 = edge[0];
            int node2 = edge[1];
            
            adj.get(node1).add(node2);
            adj.get(node2).add(node1);
        }
        //Step 2: For each vertex check for connnected components and if there is a cycle return 
        //.       true
        boolean[] visited = new boolean[V];
        for(int i=0;i<V;i++)
        {
            if(visited[i]==false)
            {
                if(checkCycle(i,adj,visited))
                return true;
            }
        }
        return false;
    }
    private boolean checkCycle(int node,List<List<Integer>> adj,boolean[] visited)
    {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{node,-1});
        visited[node]=true;
        
        while(!q.isEmpty())
        {
            int[] popped = q.poll();
            int curr = popped[0];
            int parent = popped[1];
            
            //get the neighbor
            for(int neighbor:adj.get(curr))
            {
                //not visited
                if(!visited[neighbor])
                {
                    q.offer(new int[]{neighbor,curr});
                    visited[neighbor]=true;
                }
                //already visited
                else
                {
                    if(neighbor!=parent)
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
