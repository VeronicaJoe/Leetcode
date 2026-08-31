class Solution {
    //We can perform DSU or Prims - get the valid edges -> x
    //m = n-1 (edges needed) max
    //invalid edges y = connections.length - x 
    //edgesNeeded p = m - x 
    //if(edgesNeeded > invalid edges)
    //                  No enough cables - return -1 else return edgesNeeded

    class DisjointSet
    {
        List<Integer> size = new ArrayList<>();
        List<Integer> parent = new ArrayList<>();

        public DisjointSet(int n)
        {
            for(int i=0;i<n;i++)
            {
                size.add(1);
                parent.add(i);
            }
        }

        public int findUltParent(int node)
        {
            if(node==parent.get(node))
            return node;

            int ultParent = findUltParent(parent.get(node));
            parent.set(node,ultParent);
            return ultParent;
        }

        public void unionBySize(int u,int v)
        {
            //Step 1: Find Ult Parent of u and v - Path Compression
            int ult_u = findUltParent(u);
            int ult_v = findUltParent(v);

            //Step 2: Find size of ult_u and ult_v
            int sizeU = size.get(ult_u);
            int sizeV = size.get(ult_v);

            //Step 3: Compare both the sizes
            if(sizeU<sizeV)//V -> parent
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
    public int makeConnected(int n, int[][] connections) 
    {
        int m = n-1;//no of valid edges accd to DSU
        //Step 1: Find DSU
        DisjointSet ds = new DisjointSet(n);
        int mst = 0;
        for(int[] connection:connections)
        {
            int u = connection[0];
            int v = connection[1];
            if(ds.findUltParent(u)!=ds.findUltParent(v))
            {
                //not same component
                mst++;
                ds.unionBySize(u,v);
            }
        }

        //Step 2: Get the Invalid Pairs 
        int invalid = connections.length - mst;

        //Step 3: Get the needed connections 
        int needed = m - mst;

        return (needed>invalid)?-1:needed;
    }
}
