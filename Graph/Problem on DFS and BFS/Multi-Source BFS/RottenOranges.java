class Solution {
    public int orangesRotting(int[][] grid) {
        //BFS(multi-source)
        //2 - rotten
        //1 - fresh
        //0 - empty
        int mins = 0;
        Queue<int[]> q = new LinkedList<>();
        //Step 1: Add all rotten oranges to q
        //Step 2: Count fresh oranges
        int freshCnt = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1)
                    freshCnt++;
                else if (grid[i][j] == 2)
                    q.offer(new int[] { i, j });
            }
        }
        //Step 3: Perform Multi source BFS
        final int[][] DIR = {{1,0},{-1,0},{0,1},{0,-1}};//D,U,R,L
        while (!q.isEmpty()) {
            int size = q.size();
            boolean isRotten = false;
            for (int i = 0; i < size; i++) {
                int[] node = q.poll();
                int u = node[0];
                int v = node[1];
                //Step 4: Traverse all 4 directions(adj) is it is fresh(1) and within the grid and maintain a flag-rotten-> make it rotten (2) -> add to queue

                for(int[] direction:DIR)
                {
                   int ind1 =  direction[0]+u;
                   int ind2 = direction[1]+v;

                   if(ind1>=0&&ind1<grid.length&&ind2>=0&&ind2<grid[0].length&&grid[ind1][ind2]==1)
                   {
                    q.offer(new int[]{ind1,ind2});
                   grid[ind1][ind2] = 2;//infected
                   freshCnt=freshCnt-1;
                   isRotten = true;
                   }
                }
            }
            //Step 5: After exiting the for loop - increment mins(if isRotten - true)

            if (isRotten)
                mins = mins + 1;
        }
        return (freshCnt == 0) ? mins : -1;
        //-1 signifies all not rotted refer Case 2
    }
}
