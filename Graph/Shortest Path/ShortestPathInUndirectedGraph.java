class Solution {
  //Unit weight and undirected graph
    public int shortestPath(int V, int[][] edges, int src, int dest) {
        // code here
        //Step 1: Build Adj list
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
        
        //Step 2: Build a dist[]
        int[] dist = new int[V];
        Arrays.fill(dist,Integer.MAX_VALUE);
        //make src node alone as 0 dist
        dist[src] = 0;
        
        //STEP 3:Create a queue and add the src with 0 dist into queue
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{src,0});
        
        while(!q.isEmpty())
        {
            int[] node = q.poll();
            int nodeVal = node[0];
            int nodeWeight = node[1];
            
            int neighborWeight = nodeWeight+1;
            
            //get the neighbor
            for(int neighbor:adj.get(nodeVal))
            {
                //only if the weight calc for neighbor is less than the dist[neighbor]
                //i) Update dist[neighbor]
                //ii) q.offer(neighbor,dist[neighbor])
                //Note: our goal is shorter dist so only consider them
                
                if(neighborWeight<dist[neighbor])
                {
                    dist[neighbor]=neighborWeight;
                    q.offer(new int[]{neighbor,dist[neighbor]});
                }
            }
        }
        return dist[dest]==Integer.MAX_VALUE?-1:dist[dest];
    }
}
