class Solution {
    private boolean isVowel(char ch)
    {
        if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'||ch=='A'||ch=='E'||ch=='I'||ch=='O'||ch=='U')
        return true;
        return false;
    }
    public String reverseVowels(String s) 
    {
        int n = s.length();
        int left = 0,right=n-1;
        char[] arr = s.toCharArray();
        while(left<right)
        {
            //get a vowel from left
            while(left<right&&!isVowel(arr[left]))
            {
                left++;
            }
            //get a vowel from right
            while(left<right&&!isVowel(arr[right]))
            {
                right--;
            }
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
        return new String(arr);
    }
}
