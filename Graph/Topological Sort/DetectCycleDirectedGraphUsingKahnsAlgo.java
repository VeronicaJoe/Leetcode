class Solution {
    public boolean isCyclic(int V, int[][] edges) 
    {
        //Step 1: Create Adjacent List
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
        //Step 2: Indegree[] and Queue
        Queue<Integer> q = new LinkedList<>();
        int[] indegree = new int[V];
        for(int i=0;i<V;i++)
        {
            for(int node:adj.get(i))
            {
                indegree[node]++;
            }
        }
        //Step 3: Add all nodes with indegrees 0 to Queue
        for(int i=0;i<V;i++)
        {
            if(indegree[i]==0)
            q.offer(i);
        }
        //Step 4: Perform BFS (Kahns algorithm)
        //        Pop
        //        Add to List
        //        Get the neighbors
        //        Decrement indegrees
        //        If(indegree[neighbor==0]) -> add to queue
        List<Integer> list = new ArrayList<>();
        while(!q.isEmpty())
        {
            int size = q.size();
            for(int i=0;i<size;i++)
            {
                int node = q.poll();
                list.add(node);
                
                for(int neighbor:adj.get(node))
                {
                    indegree[neighbor]=indegree[neighbor]-1;
                    if(indegree[neighbor]==0)
                    q.offer(neighbor);
                }
            }
        }
        //Step5: Check is list.size()!=V return true else return false
        return list.size()!=V;
    }
}
