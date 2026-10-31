class Solution {
    public boolean isPalindrome(String s) {

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
}
