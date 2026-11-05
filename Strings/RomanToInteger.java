class Solution {
    //Approach: If a smaller value comes before a larger value - subtract
    //Why??     VI = 5+1 = 6
    //          IV = 5-1 = 4(when a smaller value comes before larger value)
    private int value(char ch)
    {
        switch(ch)
        {
            case 'I':
            return 1;
            case 'V':
            return 5;
            case 'X':
            return 10;
            case 'L':
            return 50;
            case 'C':
            return 100;
            case 'D':
            return 500;
            case 'M':
            return 1000;
        }
        return -1;
    }
    public int romanToInt(String s) 
    {
        int total = 0,prev = 0;
        //right -> left
        int len = s.length();
        for(int i=len-1;i>=0;i--)
        {
            int curr = value(s.charAt(i));
            if(curr<prev)
            {
                total-=curr;
            }
            else 
            {
                total+=curr;
            }
            prev = curr;
        }    
        return total;
    }
}
