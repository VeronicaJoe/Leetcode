class Solution {
    //Approach(1): Using a stack
    public boolean isValid1(String s) {
        Stack<Character> st = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                st.push(ch);
            } else {
                //closing brackets
                if (!st.isEmpty()) {
                    char top = st.pop();
                    if ((ch == ')' && top == '(') || (ch == ']' && top == '[') || (ch == '}' && top == '{'))
                        continue;
                    else
                        return false;//invalid
                } else
                    return false;//invalid
            }
        }
        return st.isEmpty();
    }
    //Approach(2): Using a stack 
    public boolean isValid(String s) {
        Deque<Character> dq = new ArrayDeque<>();
        for(char ch:s.toCharArray())
        {
            if(ch=='(')
            {
                dq.push(')');
            }
            else if(ch=='[')
            {
                dq.push(']');
            }
            else if(ch=='{')
            {
                dq.push('}');
            }
            else
            {
                if(dq.isEmpty()||ch!=dq.pop())
                {
                    return false;
                }
            }
        }
        return dq.isEmpty();
    }
}
