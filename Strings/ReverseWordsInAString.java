class Solution {
    //Approach(1): Split the words in the string in array and reverse the words using 2 ptr and append back
    public String reverseWords1(String s) 
    {
        s = s.trim().replaceAll("\\s+"," ");
        String[] words = s.split(" ");
        int left = 0,right = words.length-1;
        while(left<right)
        {
            String temp = words[left];
            words[left] = words[right];
            words[right] = temp;
            left++;
            right--;
        }    
        String res = String.join(" ",words);//array to string -> using join
        return res;
    }
    //Approach(2): 
    //          --> Reverse the entire string
    //          --> Reverse each word in the string
    //          --> eg: "the sky is blue" -> "eulb si yks eht"
    //                                    -> "blue is sky the"
    public String reverseWords(String s) 
    {
        s = s.trim().replaceAll("\\s+"," ");
        char[] arr = s.toCharArray();
        reverse(arr,0,arr.length-1);

        int start=0,end=0;
        while(start<arr.length&&end<=arr.length)
        {
            if(end==arr.length||arr[end]==' ')
            {
                //end ->' '
                reverse(arr,start,end-1);
                if(end==arr.length)
                break;
                start = end+1;
            }
            end++;
        }

        //char arr -> string
        StringBuilder sb = new StringBuilder();
        for(char ch:arr)
        {
            sb.append(ch);
        }
        return sb.toString();
    }
    private void reverse(char[] arr,int left,int right)
    {
        while(left<right)
        {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}
