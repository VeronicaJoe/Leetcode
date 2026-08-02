class Solution1 {
    public ArrayList<ArrayList<Integer>> getComponents(int V, int[][] edges) 
    {
        // code here
         ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        //Step 1: Create a Edge List
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++)
        {
            // ArrayList<Integer> list = new ArrayList<>();
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++)
        {
            int[] edge = edges[i];
            int node1 = edge[0];
            int node2 = edge[1];
            adj.get(node1).add(node2);
            adj.get(node2).add(node1);
        }
        //Step 2: Traverse for every node whicb are unvisited and perform DFS
        boolean[] visited = new boolean[V];
        for(int node=0;node<V;node++)
        {
            if(!visited[node])
            {
                ArrayList<Integer> list = new ArrayList<>();
                res.add(list);
                dfs(node,visited,adj,list);
            }
        }
        return res;
    }
    private void dfs(int node,boolean[] visited,List<List<Integer>> adj,ArrayList<Integer> list)
    {
        if(visited[node])
        return;
        
        visited[node]=true;
        list.add(node);
        //get the neighbors
        for(int num:adj.get(node))
        {
            if(!visited[num])
            dfs(num,visited,adj,list);
        }
    }
}
//Using BFS

class Solution
{
    public ArrayList<ArrayList<Integer>> getComponents(int V, int[][] edges) 
    {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        //Step 1: Create a list and add the edges
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++)
        {
            adj.add(new ArrayList<>());
        }
        
        for(int i=0;i<edges.length;i++)
        {
            int[] edge = edges[i];
            int node1 = edge[0];
            int node2 = edge[1];
            
            adj.get(node1).add(node2);
            adj.get(node2).add(node1);
        }
        
        //Step 2: Traverse theough every node and perform BFS only on unvisited nodes
        boolean[] visited = new boolean[V];
        for(int node=0;node<V;node++)
        {
            if(!visited[node])
            {
                ArrayList<Integer> list = new ArrayList<>();
                res.add(list);
                bfs(node,visited,list,adj);
            }
        }
        return res;
    }
    private void bfs(int node,boolean[] visited,ArrayList<Integer> list,List<List<Integer>> adj)
    {
       Queue<Integer> q = new LinkedList<>();
       if(!visited[node])
       {
          visited[node]=true;
           q.offer(node);
        //   list.add(node);
           while(!q.isEmpty())
           {
               int popped = q.poll();
               list.add(popped);
               //get the adj nodes
               for(int num:adj.get(popped))
               {
                   if(!visited[num])
                   {
                       q.offer(num);
                       visited[num]=true;
                   }
               }
           }
       }
    
    }
}
