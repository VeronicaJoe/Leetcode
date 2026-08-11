class Solution
{
	public String findOrder(String[] words)
	{
		int n = words.length;
		//Step 1: Get all unique letter
		Set<Character> uniqueChars = new HashSet<>();
		for (String word:words)
			{
			for (char ch:word.toCharArray())
				{
				uniqueChars.add(ch);
			}
		}
		// Step 2: Construct Graph
		List<List<Integer>> edges = new ArrayList<>();
		
		for (int i = 0; i<n - 1; i++)
			{
			if (!construct(words[i], words[i + 1], edges))
				return ""; // invalid
		}
		// Step 3: Construct Adj list
		// Step 4: Construct Indegree[]
		List<List<Integer>> adj = new ArrayList<>();
		int[] indegree = new int[26];
		for (int i = 0; i<26; i++)
			{
			adj.add(new ArrayList<>());
		}
		for (List<Integer> edge:edges)
			{
			int u = edge.get(0);
			int v = edge.get(1);
			
			adj.get(u).add(v);
			indegree[v]++;
		}
		// Step 4: Add all nodes with indegree 0 -> queue
		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i<26; i++)
			{
			if (indegree[i] == 0 && uniqueChars.contains((char)(i + 'a')))
				{
				q.offer(i);
			}
		}
		
		//Step 5: Perform Kahns algo BFS
		StringBuilder res = new StringBuilder();
		while (!q.isEmpty())
			{
			int node = q.poll();
			res.append((char)(node + 'a'));
			
			//get the neighbors
			for (int neighbor:adj.get(node))
				{
				indegree[neighbor]--;
				if (indegree[neighbor] == 0)
					q.offer(neighbor);
			}
		}
		if(uniqueChars.size()==res.length())//cycle check (v.imp)
		return res.toString();
		
		return "";
	}
	private boolean construct(String s1, String s2, List<List<Integer>> edges)
	{
		int minLen = Math.min(s1.length(), s2.length());
		for (int i = 0; i<minLen; i++)
			{
			if (s1.charAt(i) != s2.charAt(i))
				{
				int ch1 = s1.charAt(i) - 'a';
				int ch2 = s2.charAt(i) - 'a';
				
				edges.add(Arrays.asList(ch1, ch2));//different letters found
				return true;
			}
		}
		return s1.length()<=s2.length();
		//if s1 > s2 => s2 is a prefix word of s1 - invalid ordering 
		//else => same words - correct ordering but no different letters found
	}
}
