class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        //Detect Cycle in a Directed Graph using DFS (vis[] and pathVis[])

        //Note: Given graph is already a Adjacency List so no need to construct
        int n = graph.length;
        //Step 1:Perform DFS on every unvisited components
        boolean[] visited = new boolean[n];
        boolean[] pathVisited = new boolean[n];
        for(int i=0;i<n;i++)
        {
            if(!visited[i])
            {
                dfs(i,visited,pathVisited,graph);
            }
        }
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            if(!pathVisited[i])
            res.add(i);
        }
        return res;
    }

    private boolean dfs(int node,boolean[] visited,boolean[] pathVisited,int[][] graph)
    {
        visited[node]=true;
        pathVisited[node]=true;

        //get the neighbor
        for(int neighbor:graph[node])
        {
            if(!visited[neighbor])
            {
                if(dfs(neighbor,visited,pathVisited,graph))
                return true;
            }
            else
            {
                if(pathVisited[neighbor])
                return true;//cycle
            }

        }
        //backtrack
        //no cycle
        pathVisited[node]=false;
        return false;
    }
}
