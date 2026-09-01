class Solution {
    class DisjointSet
    {
        List<Integer> parent = new ArrayList<>();
        List<Integer> size = new ArrayList<>();

        public DisjointSet(int n)
        {
            for(int i=0;i<=n;i++)
            {
                parent.add(i);
                size.add(1);
            }
        }

        //Find Ultimate Parent
        public int findUltParent(int node)
        {
            if(node==parent.get(node))
            return node;

            int ultParent = findUltParent(parent.get(node));
            parent.set(node,ultParent);
            return ultParent;
        }

        //Union By Size
        public void unionBySize(int u,int v)
        {
            //Step 1: Get Up of u and v
            int ult_u = findUltParent(u);
            int ult_v = findUltParent(v);

            //already in the same component
            if(ult_u==ult_v)
            return;

            //Step 2: Find size of ult_u and ult_v
            int sizeU = size.get(ult_u);
            int sizeV = size.get(ult_v);

            if(sizeU<sizeV)
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
    public int removeStones(int[][] stones) 
    {
        int TOTAL_STONES = stones.length;
        //Step 1:Represent rows and columns as continuity
        int maxRow = 0;
        int maxCol = 0;
        for(int[] stone:stones)
        {
            maxRow = Math.max(maxRow,stone[0]);
            maxCol = Math.max(maxCol,stone[1]);
        }
        DisjointSet ds = new DisjointSet(maxRow+maxCol+1);

        Set<Integer> set = new HashSet<>();

        for(int[]stone:stones)
        {
            int row = stone[0];
            int col = stone[1]+maxRow+1;

            //perform union
            ds.unionBySize(row,col);
            set.add(row);
            set.add(col);
        }

        //Iterate through the set and get the components count
        int component = 0;
        for(int stone:set)
        {
            if(stone==ds.findUltParent(stone))
            component++;
        }
        return TOTAL_STONES - component;
    }
}
