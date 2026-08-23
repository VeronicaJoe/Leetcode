class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) 
    {
        //Step 1: Build Adj list
        //({{0,1},{0,2}},{{2,3},{3,2}}} - List<List<int[]>> - node and price
        int totalStops = k+1;//k stops + dest
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }

        for(int[] flight:flights)
        {
            int from = flight[0];
            int to = flight[1];
            int price = flight[2];

            adj.get(from).add(new int[]{to,price});//directed
        }

        //Step 2: dist[] and queue<stop,node,dist>

        int[] dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src] = 0;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,src,0});

        while(!q.isEmpty())
        {
            int[] popped = q.poll();
            int stop = popped[0];
            int nodeVal = popped[1];
            int nodeDist = popped[2];

            //get the neighbors
            for(int[] neighbor:adj.get(nodeVal))
            {
                int neighborVal = neighbor[0];
                int price = neighbor[1];
                int newStop = stop+1;

                //1st priority -> lesser stops
                //2nd priority -> dist check
                if(newStop<=totalStops)
                {
                    if(price+nodeDist<dist[neighborVal])
                    {
                        dist[neighborVal] = price+nodeDist;
                        q.offer(new int[]{newStop,neighborVal,dist[neighborVal]});
                    }
                }
            }
        }
        return (dist[dst]==Integer.MAX_VALUE)?-1:dist[dst];
    }
}
