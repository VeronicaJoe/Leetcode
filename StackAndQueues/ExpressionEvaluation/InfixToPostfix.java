class Solution {
    private static int precedence(char ch)
    {
        if(ch=='^')
        return 3;
        else if(ch=='/'||ch=='*')
        return 2;
        else if(ch=='+'||ch=='-')
        return 1;
        else 
        return -1;
    }
    public static String infixToPostfix(String s) 
    {
        // code here
        Deque<Character> st = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        
        for(char ch:s.toCharArray())
        {
            if(Character.isLetterOrDigit(ch))
            {
                sb.append(ch);
            }
            else if(ch=='(')
            {
                st.push(ch);
            }
            else if(ch==')')
            {
                while(!st.isEmpty()&&st.peek()!='(')
                {
                    sb.append(st.pop());
                }
                st.pop();//remove the (
            }
            else
            {
                //operator
                while(!st.isEmpty()&&st.peek()!='('&&(precedence(st.peek())>precedence(ch)||(precedence(st.peek())==precedence(ch)&&ch!='^')))
                {
                    sb.append(st.pop());
                }
                st.push(ch);
            }
        }
        while(!st.isEmpty())
        {
            sb.append(st.pop());
        }
        return sb.toString();
    }
}
