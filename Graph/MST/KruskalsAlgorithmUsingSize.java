class Solution {
    static class DisjointSet
    {
        List<Integer> size = new ArrayList<>();
        List<Integer> parent = new ArrayList<>();
        
        public DisjointSet(int n)
        {
            for(int i=0;i<n;i++)
            {
                size.add(1);//initially each component of size 1
                parent.add(i);
            }
        }
        
        //find ult parent - path compression
        public int findUltParent(int node)
        {
            if(node==parent.get(node))
            return node;
            
            int ultParent = findUltParent(parent.get(node));
            parent.set(node,ultParent);//set the new ult parent for the node
            return ultParent;
        }
        
        public void unionBySize(int u,int v)
        {
            //Step 1: get the ult parent of u and v
            int ult_u = findUltParent(u);
            int ult_v = findUltParent(v);
            
            if(ult_u==ult_v)
            return;//already in same component
            //Step 2: get the size of ult_u and ult_v
            int sizeU = size.get(ult_u);
            int sizeV = size.get(ult_v);
            //Step 3: 
            if(sizeU<sizeV)//sizeU = 3 sizeV = 5
            {
                parent.set(ult_u,ult_v);
                size.set(ult_v,size.get(ult_u)+size.get(ult_v));
            }
            else
            {
                parent.set(ult_v,ult_u);
                size.set(ult_u,size.get(ult_u)+size.get(ult_v));
            }
        }
    }
    static int kruskalsMST(int V, int[][] edges) 
    {
        List<int[]> mstEdges = new ArrayList<>();
        int sum = 0;
        DisjointSet ds = new DisjointSet(V);
        // code here
        //Sort the edges in asc order accrd to edgeWeights
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[2],b[2]));
        for(int[] edge:edges)
        {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            pq.offer(new int[]{u,v,wt});
        }
        
        while(!pq.isEmpty())
        {
            int[] element = pq.poll();
            int u = element[0];
            int v = element[1];
            int wt = element[2];
            
            if(ds.findUltParent(u)!=ds.findUltParent(v))
            {
                //dont belong to same component
                ds.unionBySize(u,v);
                mstEdges.add(new int[]{u,v});
                sum+=wt;
            }
            
        }
        return sum;
        
    }
}
