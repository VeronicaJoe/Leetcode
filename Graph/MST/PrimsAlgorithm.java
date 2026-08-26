class Solution {
    public int spanningTree(int V, int[][] edges) 
    {
        //PRIM'S ALGORITHM - Lets us know the min path sum in a MST and the adjacency list of that MST
        //Step 1: Construct the adj list
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
            
            adj.get(u).add(new int[]{v,wt});
            adj.get(v).add(new int[]{u,wt});
        }
        //Step 2: Initial Configurations:
        boolean[] visited = new boolean[V];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));//<wt,node,parent>
        List<int[]> mst = new ArrayList<>();
        int sum = 0;
        
        pq.offer(new int[]{0,0,-1});
        while(!pq.isEmpty())
        {
            int[] element = pq.poll();
            int wt = element[0];
            int v = element[1];//node
            int u = element[2];//parent
            
            if(visited[v])
            continue;
            
            
            //(1) Mark as visited
            visited[v]=true;
            //(2) Add node to sum
            sum+=wt;
            //(3) Check if parent exist then add to MST adj list
            if(u!=-1)
            {
                mst.add(new int[]{u,v});//parent,node
            }
            //(4) Get the neighbors
            for(int[] neighbor:adj.get(v))
            {
                int neighborVal = neighbor[0];
                int edgeWt = neighbor[1];
                
                if(!visited[neighborVal])
                pq.offer(new int[]{edgeWt,neighborVal,v});//<wt,node,parent>
            }
        }
        return sum;
    }
}
