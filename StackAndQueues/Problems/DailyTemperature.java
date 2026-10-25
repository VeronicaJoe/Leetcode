class Solution {
    public int[] dailyTemperatures(int[] temperatures) 
    {
        //Refer:NGE and instead of storing values in stack store index
        int n = temperatures.length;
        int[] warmerDays = new int[n];

        Deque<Integer> st = new ArrayDeque<>();
        for(int i=n-1;i>=0;i--)
        {
            while(!st.isEmpty()&&temperatures[st.peek()]<=temperatures[i])
            {
                st.pop();
            }
            if(st.isEmpty())
            {
                warmerDays[i] = 0;
            }
            else
            {
                warmerDays[i] = st.peek()-i;
            }
            st.push(i);
        }    
        return warmerDays;
    }
}
