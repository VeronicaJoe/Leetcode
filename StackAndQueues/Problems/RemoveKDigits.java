class Solution {
    public String removeKdigits(String num, int k) 
    {
        //We follow NGE
        //Step 1: Add to stack(increasing order eg:1->2->3->....)
        Deque<Character> st = new ArrayDeque<>();
        for(char ch:num.toCharArray())
        {
            //removing the larger number before smaller number to obtain a smaller number
            while(!st.isEmpty()&&k>0&&st.peek()>ch)
            {
                k--;
                st.pop();
            }
            st.push(ch);
        }    
        //Step 2: Pop out remaining elements from stack based on k
        while(k>0)
        {
            k--;
            st.pop();
        }
        //Step 3: Append to StringBuilder
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty())
        {
            sb.append(st.pop());
        }
        sb.reverse();
        //Step 4:Remove trailing zeroes
        int i=0;
        while(i<sb.length()&&sb.charAt(i)=='0')
        {
            i++;
        }
        String res = sb.substring(i);

        return res.isEmpty()?"0":res;
    }
}
