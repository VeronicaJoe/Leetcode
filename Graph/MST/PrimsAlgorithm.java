class Solution {
    public int spanningTree(int V, int[][] edges) {
        // code here
        //Step 1: Get the adjacency list
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
            
            //bidirectional
            adj.get(u).add(new int[]{v,wt});
            adj.get(v).add(new int[]{u,wt});
        }
        
        //Step 2: Initial Config:
        //        Visited[], PQ<wt,node,parent>, sum = 0, mst edges list<parent,node>
        boolean[] visited = new boolean[V];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));//minheap
        List<int[]> mstList = new ArrayList<>();
        int sum = 0;
        
        //Step 3: intially add srcNode = 0 to PQ
        pq.offer(new int[]{0,0,-1});//no parent and no edge wt ad src = 0
        
        //Step 4: Till the PQ is not empty
        //      i)Pop from PQ
        //      ii)Check if node already visited - skip
        //      iii)Mark node as visited
        //      iv)If parent is -1 then dont add to MSTList and sum
        //      v)Else add to MSTList and sum up
        //      vi) Get the adj nodes of node if they are not visited add to PQ
        
        while(!pq.isEmpty())
        {
            int[] element = pq.poll();
            int wt = element[0];
            int node = element[1];
            int parent = element[2];
            
            if(visited[node])
            continue;
            
            visited[node] = true;
            sum+=wt;
            if(parent!=-1)
            {
                mstList.add(new int[]{parent,node});
            }
            //get neighbors
            for(int[] neighbor:adj.get(node))
            {
                int neighborVal = neighbor[0];
                int neighborWt = neighbor[1];
                if(!visited[neighborVal])
                {
                    pq.offer(new int[]{neighborWt,neighborVal,node});
                }
            }
        }
        return sum;
    }
}
