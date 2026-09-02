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
        
        //find ult parent
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
            int ult_u = findUltParent(u);
            int ult_v = findUltParent(v);
            
            if(ult_u==ult_v)
            {
                //already connected
                return;
            }
            
            if(size.get(ult_u)<size.get(ult_v))
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
    public ArrayList<Integer> numOfIslands(int n, int m, int[][] operators) 
    {
        // Your code here
        //Step 1: DSU for n*m
        DisjointSet ds = new DisjointSet(n*m);
        boolean[][] visited = new boolean[n][m];
        int[][] DIR = {{0,1},{1,0},{-1,0},{0,-1}};
        
        int cnt = 0;//global
        ArrayList<Integer> res = new ArrayList<>();
        for(int[] operator:operators)
        {
            int row = operator[0];
            int col = operator[1];
            
            //Edge Case: if already visited get the last updated cnt
            if(visited[row][col])
            {
                res.add(cnt);
                continue;
            }
            
            //Step 2: Not visited
            visited[row][col] = true;
            cnt++;
            
            //Step 3: Get the neighbors of (row,col)
            for(int[] direction: DIR)
            {
                int adjRow = row+direction[0];
                int adjCol = col+direction[1];
                
                //check if the adj already visited only then it can be connected
                if(isValidCell(adjRow,adjCol,n,m)&&visited[adjRow][adjCol])
                {
                    //check if the adj and curent node dont belong to same component so that we can avoid duplicates
                    int adjNode = adjRow*m+adjCol;
                    int node = row*m+col;
                    
                    if(ds.findUltParent(adjNode)!=ds.findUltParent(node))
                    {
                        ds.unionBySize(adjNode,node);
                        cnt--;
                    }
                }
            }
            res.add(cnt);
        }
        return res;
    }
    
    public boolean isValidCell(int row,int col,int n,int m)
    {
        if(row<0||col<0||row>=n||col>=m)
        return false;
        return true;
    }
}
