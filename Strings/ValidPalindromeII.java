class Solution {
    //Brute Force: Hypothetically delete each char and check for palindrome
    public boolean validPalindrome1(String s) 
    {
        int len = s.length();
        for(int i=0;i<len;i++)
        {
            String str = s.substring(0,i)+s.substring(i+1);
            if(isPalindrome(str))
            return true;
        }
        return false;
    }
    private boolean isPalindrome(String str)
    {
        int left = 0,right =str.length()-1;
        while(left<right)
        {
            if(str.charAt(left)!=str.charAt(right))
            return false;

            left++;
            right--;
        }
        return true;
    }
    //Optimal: Using 2 pointer (move the pointers and check for palindrome)
    public boolean validPalindrome(String s) 
    {
        int left = 0,right = s.length()-1;
        while(left<right)
        {
            if(s.charAt(left)!=s.charAt(right))
            {
                return isPal(s,left+1,right)||isPal(s,left,right-1);
            }
            left++;
            right--;
        }
        return true;
    }
        private boolean isPal(String str,int left,int right)
    {
        while(left<right)
        {
            if(str.charAt(left)!=str.charAt(right))
            return false;

            left++;
            right--;
        }
        return true;
    }
}
