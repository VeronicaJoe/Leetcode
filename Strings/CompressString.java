class Solution {
    public int compress(char[] chars) 
    {
        //Edge Case:
        int length = chars.length;
        if(length==1)
        return 1;

        //Compare consequtive chars and when a diff   
        char prevChar = chars[0];
        int cnt = 1;
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=length;i++)
        {
            //Add the last combination
            if(i==length) 
            {
                sb.append(chars[i-1]);
                if(cnt>1)
                sb.append(cnt);
                break;
            }
            char currChar = chars[i];
            if(currChar==prevChar)
            {
                cnt++;
            }
            else
            {
                sb.append(prevChar);
                if(cnt>1)
                sb.append(cnt);
                //Reset + Update
                cnt = 1;
                prevChar = currChar;
            }
        } 
        //Update the chars array
        int ind = 0;
        for(char ch:sb.toString().toCharArray())
        {
            chars[ind++]=ch;
        }
        return ind;
    }
}
