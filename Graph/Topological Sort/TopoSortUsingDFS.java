

// Works only for DAG:

class Solution {
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        //Using DFS
        //Steps1: Determine adj list for each vertex
        //Step 2: Maintain a visited[] and stack to store nodes
        //Step 3: For each unvisited vertex perform DFS
        //Step 4: DFS(node)
        //                  Mark as visited
        //                  Check for adj nodes
        //                  if unvisited - perform DFS(adj)
        //                  On backtracking add the node to Stack
        //Step 5: Pop out all the nodes from stack - TOPO SORT

	List<List<Integer>> adj = new ArrayList<>();
	for(int i=0;i<V;i++)
	{
		adj.add(new ArrayList<>());
	}
	for(int[] edge: edges)
	{
		int u = edge[0];
		int v = edge[1];
		adj.get(u).add(v);
	}

	boolean[] visited = new boolean[V];
	Stack<Integer> st = new Stack<>();
	for(int i=0;i<V;i++)
	{
		if(!visited[i])
		{
			dfs(i,visited,adj,st);
		}
	}
	ArrayList<Integer> topoSort = new ArrayList<>();
	while(!st.isEmpty())
	{
		topoSort.add(st.pop());
	}
return topoSort;
	
    }
private void dfs(int node,boolean[] visited, List<List<Integer>> adj,Stack<Integer> st)
{
	visited[node] = true;
	//get the neighbours
	for(int neighbor:adj.get(node))
	{
		if(!visited[neighbor])
		{
			dfs(neighbor,visited,adj,st);
		}
	}
	st.push(node);
}
}
