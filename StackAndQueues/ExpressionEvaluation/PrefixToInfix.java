class Solution {
    static String preToInfix(String s) {
        // code here
        //Step 1: Reverse Expression(its to do it when we first have operands)
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        Deque<String> st = new ArrayDeque<>();
        //Step 2:
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
                
                String res = '('+op1+ch+op2+')';
                st.push(res);
            }
        }
        return st.pop();
        
    }
}
