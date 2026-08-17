class Solution {
    public ArrayList<Integer> dijkstra(int V, int[][] edges, int src) {
        // code here
        //Step 1: Build Adjacency List
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0;i<V;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int[] edge:edges)
        {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];
            
            //undirected u<->v
            adj.get(u).add(new int[]{v,weight});
            adj.get(v).add(new int[]{u,weight});
        }
        //Step 2: Whenever there is a path - declare a dist[] with Integer.MAX_VALUE
        int[] dist = new int[V];
        Arrays.fill(dist,Integer.MAX_VALUE);
        //Step 3: Use a priority queue {dist,node} - ensures that smallest dist is on top
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));//min heap
        //Step 4: Add the src node into q with dist 0 and update the dist[src]=0
        dist[src] = 0;
        pq.offer(new int[]{0,src});
        //Step 5: Pop and get the neighbors 
        //Step 6: If poppedNodeWeight + neighborEdgeWeight < dist[neighbor] 
        //              Update: dist[neighbor] = poppedNodeWeight + neighborEdgeWeight
        //              Add {dist[neighbor],neighborNodeVal} -> queue
        while(!pq.isEmpty())
        {
            int[] popped = pq.poll();
            int nodeDist = popped[0];
            int nodeVal = popped[1];
            if(nodeDist>dist[nodeVal])
            continue; // stale — already settled via a cheaper path
            for(int[] neighbor:adj.get(nodeVal))
            {
                int neighborVal = neighbor[0];
                int edgeWeight = neighbor[1];

                if(nodeDist+edgeWeight<dist[neighborVal])
                {
                    dist[neighborVal]=nodeDist+edgeWeight;
                    pq.offer(new int[]{dist[neighborVal],neighborVal});
                }
            }
        }
        ArrayList<Integer> distList = new ArrayList<>();
        for(int d:dist)
        {
            int nodeDist = d==Integer.MAX_VALUE?-1:d;
            distList.add(nodeDist);
        }
        return distList;
        //Note: Djikstra Algo is not applicable for negative edges as it leads to infinite cycle
        
        
    }
}
