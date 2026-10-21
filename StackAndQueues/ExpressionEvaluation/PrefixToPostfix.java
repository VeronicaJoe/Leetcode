class Solution {
    static String preToPost(String s) 
    {
        // code here
        //Step 1: Reverse the expression 
        StringBuilder sb = new StringBuilder(s);
        Deque<String> st = new ArrayDeque<>();
        
        sb.reverse();
        for(int i=0;i<sb.length();i++)
        {
            char ch = sb.charAt(i);
            if(Character.isLetterOrDigit(ch))
            {
                st.push(String.valueOf(ch));
            }
            else
            {
                //operator
                String op1 = st.pop();
                String op2 = st.pop();
                
                String res = op1+op2+ch;
                st.push(res);
            }
        }
        return st.pop();
    }
}
