class Solution {
	public ArrayList<Integer> nextLargerElement(int[] arr)
	{
		// code here
		Deque<Integer> st = new ArrayDeque<>();
		ArrayList<Integer> nge = new ArrayList<>();
		int n = arr.length;
		for (int i = n - 1; i >= 0; i--)
		{
			// not a nge
			while (!st.isEmpty() && st.peek() <= arr[i])
			{
				st.pop();
			}

			if (st.isEmpty())
				nge.add(-1);
			else
			    nge.add(st.peek());
			st.push(arr[i]);
		}
		Collections.reverse(nge);
		return nge;
		
	}
}
