class Solution {
    public ArrayList<Integer> bellmanFord(int V, int[][] edges, int src) 
    {
        // code here
        ArrayList<Integer> res= new ArrayList<>();
        //Step 1: Intial config: dist[] and dist[src] = 0
        int[] dist = new int[V];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src] = 0;
        //Step 2: For V-1 iterations perform relaxation on all edges
        for(int i=1;i<=V-1;i++)
        {
            for(int[] edge:edges)
            {
                int nodeU = edge[0];
                int nodeV = edge[1];
                int wt = edge[2];
                
                //Integer Overflow check
                if(dist[nodeU]==Integer.MAX_VALUE)
                continue;
                
                if(dist[nodeU]+wt<dist[nodeV])
                {
                    dist[nodeV] = dist[nodeU]+wt;
                }
            }
            
        }
        
        //Step 3: Detect Negative Cycle - perform Vth iteration - if still there is a update -> cycle
        for(int[] edge:edges)
        {
            int nodeU = edge[0];
            int nodeV = edge[1];
            int wt = edge[2];
            
            if(dist[nodeU]!=Integer.MAX_VALUE&&dist[nodeU]+wt<dist[nodeV])
            {
                res.add(-1);
                return res;
            }
        }
        for(int d:dist)
        {
            d = (d==Integer.MAX_VALUE)?100000000:d;
            res.add(d);
        }
        return res;
    }
}
