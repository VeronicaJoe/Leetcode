class Solution {
    public int myAtoi(String s) 
    {
        int n = s.length();
        //Step 1: Skip the leading zeroes
        int i = 0;
        while(i<n&&s.charAt(i)==' ')
        {
            i++;
        }    
        //Edge Case: All are ' '
        if(i==n)
        return 0;

        //Step 2: Determine the sign
        int sign = 1;
        if(s.charAt(i)=='+'||s.charAt(i)=='-')
        {
            if(s.charAt(i)=='-')
            sign = -1;

            i++;
        }

        //Step 3:Form the number
        //      Integer.MAX_VALUE = 2147483647
        int num = 0;
        while(i<n&&Character.isDigit(s.charAt(i)))
        {
            int digit = s.charAt(i) - '0';//ascii conversion
            if(num>Integer.MAX_VALUE/10 || (num==Integer.MAX_VALUE/10&&digit>7))
            {
                return (sign==1)?Integer.MAX_VALUE:Integer.MIN_VALUE;
            }
            num = num*10+digit;
            i++;
        }
        return sign * num;
    }
}
