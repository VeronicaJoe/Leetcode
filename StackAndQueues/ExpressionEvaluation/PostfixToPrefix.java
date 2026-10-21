class Solution {
    static String postToPre(String s) 
    {
        // code here
        Deque<String> st  = new ArrayDeque<>();
        for(char ch:s.toCharArray())
        {
            if(Chracter.isLetterOrDigit(ch))
            {
                st.push(String.valueOf(ch));
            }
            else
            {
                //operand
                String op2 = st.pop();
                String op1 = st.pop();
                
                String res = ch+op1+op2;
                st.push(res);
            }
        }
        return st.pop();
    }
}
