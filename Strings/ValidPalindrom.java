class Solution {
    public boolean isPalindrome1(String s) {

        //2 pointer approach   
        s = s.trim();
        int len = s.length();
        if (len == 0)
            return true;
        s = s.toLowerCase();
        int left = 0, right = len - 1;
        while (left < right) {
            //only check for alphanumeric chars
            while(left<right&&!Character.isLetterOrDigit(s.charAt(left)))
            {
                left++;
            }
            while(left<right&&!Character.isLetterOrDigit(s.charAt(right)))
            {
                right--;
            }
            if(s.charAt(left)!=s.charAt(right))
            return false;
            left++;
            right--;
        }
        return true;
    }
    //Use a stack
    public boolean isPalindrome(String s) 
    {
        //Add all chars to stack and pop and compare
        Deque<Character> st = new ArrayDeque<>();
        s = s.trim();
        if(s.length()==0)
        return true;

        //Step 1: Push
        s = s.toLowerCase();
        for(char ch:s.toCharArray())
        {
            if(Character.isLetterOrDigit(ch))
            {
                st.push(ch);
            }
        }
        //Step 2: Pop and Compare
        int ind = 0;
        while(!st.isEmpty())
        {
            if(!Character.isLetterOrDigit(s.charAt(ind)))
            {
                ind++;
                continue;
            }
            if(st.pop()!=s.charAt(ind))
            return false;
            ind++;
        }
        return true;
    }
}
