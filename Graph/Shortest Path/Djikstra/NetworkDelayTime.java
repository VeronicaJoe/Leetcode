class Solution {
    public int networkDelayTime(int[][] times, int n, int k) 
    {
        //1-based indexed array
        //Step 1: Build Adj list
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++)
        {
            adj.add(new ArrayList<>());
        }    

        for(int[] time:times)
        {
            int u = time[0];
            int v = time[1];
            int wt = time[2];

            adj.get(u).add(new int[]{v,wt});//directed
        }

        //Step 2: dist[] and priorityQueue<dist,node>
        int[] dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k]=0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        pq.offer(new int[]{0,k});

        while(!pq.isEmpty())
        {
            int[] edge = pq.poll();
            int nodeVal = edge[1];
            int nodeDist = edge[0];

            if(nodeDist>dist[nodeVal])
            continue;
            //get the neighbors
            for(int[] neighbor:adj.get(nodeVal))
            {
                int neighborVal = neighbor[0];
                int edgeWt = neighbor[1];

                if(nodeDist+edgeWt<dist[neighborVal])
                {
                    dist[neighborVal] = nodeDist+edgeWt;
                    pq.offer(new int[]{dist[neighborVal],neighborVal});
                }
            }
        }

        //max dist from ind 1->n-1 -> minimum time it takes for all nodes to the receive signal from k
        int max = Integer.MIN_VALUE;
        for(int i=1;i<=n;i++)
        {
            max = Math.max(max,dist[i]);
        }
        return max==Integer.MAX_VALUE?-1:max;
    }
}
