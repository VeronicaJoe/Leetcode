class Solution {
	public ArrayList<Integer> topoSort(int V, int[][] edges) {
		// Using BFS - Kahn’s Algorithm
		// Step 1: Create adjacency list - Edges
		
		List<List<Integer>> adj = new ArrayList<>();
		for (int i = 0; i<V; i++)
		{
			adj.add(new ArrayList<>());
		}
		for (int[] edge:edges)
		{
			int u = edge[0];
			int v = edge[1];
			adj.get(u).add(v);
		}
		// Step 2: Indegree[]
		
		int[] inDegree = new int[V];
		for (int i = 0; i<V; i++)
		{
			for (int node:adj.get(i))
				{
				inDegree[node] = inDegree[node]+1;
			}
		}
		// Step 3: Create a Queue to perform BFS
		Queue<Integer> q = new LinkedList<>();
		
		// Step 4: Add all the nodes with in degree - 0 in Queue
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i<V; i++)
		{
			if (inDegree[i] == 0)
				q.offer(i);
		}
		// Step 5: perform BFS
		//		I)pop and add to resultant list
		//		ii)get the neighbours and decrement in the in degree
		//		iii)if indegree becomes 0 add to queue
		
		while (!q.isEmpty())
		{
			int size = q.size();
			for (int i = 0; i<size; i++)
				{
				int node = q.poll();
				list.add(node);
				
				// get neighbours
				for (int neighbor:adj.get(node))
					{
					inDegree[neighbor] = inDegree[neighbor]-1;
					if (inDegree[neighbor] == 0)
						q.offer(neighbor);
				}
			}
		}
		return list;
	}
}
