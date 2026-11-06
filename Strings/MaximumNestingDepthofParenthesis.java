class Solution {
    public int maxDepth(String s) 
    {
        //if '(' -> increment
        //if ')' -> decrement
        int maxDepth = 0;
        int depth = 0;
        for(char ch:s.toCharArray())
        {
            if(ch=='(')
            {
                depth++;
                maxDepth = Math.max(maxDepth,depth);
            }
            else if(ch==')')
            {
                depth--;
            }
        }   
        return maxDepth;
    }
}
