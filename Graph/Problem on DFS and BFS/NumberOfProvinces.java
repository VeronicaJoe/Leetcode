class Solution {
    //Connected components
    public int findCircleNum(int[][] isConnected) 
    {
        int provinces = 0,n=isConnected.length;
        boolean[] visited = new boolean[n];
        //perform DFS for each and every city which are unvisited
        for(int city=0;city<n;city++)
        {
            if(!visited[city])
            {
                provinces++;
                dfs(city,visited,isConnected);
            }
        }
        return provinces;
    }
    private void dfs(int city,boolean[] visited,int[][] isConnected)
    {
        //base case
        if(visited[city])
        return;

        //recursive case
        visited[city] = true;
        //perform DFS on the neighboring cities
        for(int nextCity=0;nextCity<isConnected.length;nextCity++)
        {
            if(isConnected[city][nextCity]==1)
            dfs(nextCity,visited,isConnected);
        }
    }
}
