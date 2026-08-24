class Solution {
    public int countPaths(int n, int[][] roads) 
    {

         //Step 1: Build Adj list
          int MOD = 1_000_000_007;//1e9+7
        int src = 0, dest = n-1;
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }

        for(int[] road:roads)
        {
            int u = road[0];
            int v = road[1];
            int time = road[2];

            adj.get(u).add(new int[]{v,time});
            adj.get(v).add(new int[]{u,time});
        }

        //Step 2: dist[], ways[], PriorityQueue<dist,node>
        PriorityQueue<long[]> pq = new PriorityQueue<>((a,b)->Long.compare(a[0],b[0]));
        pq.offer(new long[]{0,src});

        long[] dist = new long[n];
        Arrays.fill(dist,Long.MAX_VALUE);
        dist[src] = 0;

        int[] ways = new int[n];
        ways[src] = 1;

          //Step 3: Perform Djikstra's algorithm
        //        Pop from queue
        //        Get the neighbors from adj list
        //        calc new dist
        //        if(new_dist<dist[neighbor]) 
        //              i)update new_dist
        //              ii)if(neighbor==dest) -> ways[neighbor]+=ways[poppedNode]
        //                  else -> ways[neighbor]++
        //              iii)pq.add(new_dist,neighbor)
        //        if(new_dist==dist[neighbor])
        //              i)if(neighbor==dest) -> ways[neighbor]+=ways[poppedNode]
        //                else -> ways[neighbor]++
        while(!pq.isEmpty())
        {
            long[] popped = pq.poll();
            int nodeVal = (int)popped[1];
            long nodeDist = popped[0];//dist -> long

            if(nodeDist>dist[nodeVal])
            continue;
            for(int[] neighbor:adj.get(nodeVal))
            {
                int neighborVal = neighbor[0];
                int neighborDist = neighbor[1];

                if(neighborDist+nodeDist<dist[neighborVal])
                {
                    dist[neighborVal] = (long)(neighborDist+nodeDist);
                    ways[neighborVal]=ways[nodeVal];
                    pq.offer(new long[]{dist[neighborVal],neighborVal});
                }
                else if(neighborDist+nodeDist==dist[neighborVal])
                {
                    ways[neighborVal]=(ways[neighborVal]+ways[nodeVal])%MOD;
                }
            }
        } 
        return (int)(ways[dest]%MOD);
    }
}
