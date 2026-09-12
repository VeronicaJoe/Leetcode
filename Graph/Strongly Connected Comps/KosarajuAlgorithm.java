class Solution {
    public int countSCC(int V, int[][] edges) {
        // code here
        //Step 1: Create Graph
        List<List<Integer>> graph = new ArrayList<>();
        List<List<Integer>> reversedGraph = new ArrayList<>();
        for(int i=0;i<V;i++)
        {
            graph.add(new ArrayList<>());
            reversedGraph.add(new ArrayList<>());
        }
        for(int[] edge:edges)
        {
            int u = edge[0];
            int v = edge[1];
            
            graph.get(u).add(v);
            reversedGraph.get(v).add(u);//reversed graph used in Step 3
        }
        //Step 2: Perform Topo Sort using DFS
        Stack<Integer> st = new Stack<>();
        boolean[] visited = new boolean[V];
        for(int i=0;i<V;i++)
        {
            if(!visited[i])
            {
                topo(i,visited,graph,st);
            }
        }
        //Step 3: Reverse the graph edges
        //Step 4: Perform DFS
        Arrays.fill(visited,false);//reset the existing visited array
        int scc=0;
        while(!st.isEmpty())
        {
            int node = st.pop();
            if(!visited[node])
            {
                scc++;
                dfs(node,visited,reversedGraph);
            }
        }
        return scc;
    }
    private void dfs(int node,boolean[] visited,List<List<Integer>> reversedGraph)
    {
        visited[node]=true;
        //get the adj
        for(int neighbor:reversedGraph.get(node))
        {
            if(!visited[neighbor])
            {
                dfs(neighbor,visited,reversedGraph);
            }
        }
    }
    private void topo(int node,boolean[] visited,List<List<Integer>> graph,Stack<Integer> st)
    {
        visited[node]=true;
        //get the adj
        for(int neighbor:graph.get(node))
        {
            if(!visited[neighbor])
            {
                topo(neighbor,visited,graph,st);
            }
        }
        //backtrack
        st.push(node);
    }
}
