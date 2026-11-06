class Solution {
    //Brute Force:
    //          If num - store it
    //          If [ - append the string(res) num times but before that if there is a inner [] then recursively call fxn
    //          If ] - return string
    //          If char - append to res
    int i = 0;
    public String decodeString1(String s) 
    {
        return helper(s);
    }
    private String helper(String s)
    {
        StringBuilder res = new StringBuilder();
        int num = 0;
        while(i<s.length())
        {
            char ch = s.charAt(i);
            if(Character.isDigit(ch))
            {
                num = num*10+(ch-'0');//cast it(ch-'0') + multiple digits(num*10)
            }
            else if(ch=='[')
            {
                i++;//skip
                String inner = helper(s);//2a[3[ca]]
                for(int i=1;i<=num;i++)
                {
                    res.append(inner);
                }
                num = 0;
            }
            else if(ch==']')
            {
                return res.toString();
            }
            else
            {
                //char
                res.append(ch);
            }
            i++;
        }
        return res.toString();
    }
    //Optimal: Using Stack
    //         Maintain 2 vars: currStr="" and currNum=0
    //         Operations(2 stacks):
    //                      If num -> update currNum
    //                      If char -> update currStr
    //                      If '[' ->push currNum -> numSt and currStr -> strSt 
    //                             ->reset both currNum and currStr
    //                      If ']' ->repeat currStr 'n' times(popped from numSt)
    //                             ->pop from numSt and strSt and append strSt to currStr 
    public String decodeString(String s) 
    {
        Deque<Integer> numSt = new ArrayDeque<>();
        Deque<String> strSt = new ArrayDeque<>();

        int currNum = 0;
        StringBuilder currStr = new StringBuilder();

        int i=0;
        while(i<s.length())
        {
            char ch = s.charAt(i);
            if(Character.isDigit(ch))
            {
                currNum = currNum*10+(ch-'0');
            }
            else if(Character.isLetter(ch))
            {
                currStr.append(ch);
            }
            else if(ch=='[')
            {
                //push
                numSt.push(currNum);
                strSt.push(String.valueOf(currStr));
                currNum = 0;
                currStr = new StringBuilder();
            }
            else
            {
                //pop
                int num = numSt.pop();
                StringBuilder str = new StringBuilder(strSt.pop());
                //eg: accacc
                //where 
                while(num>0)
                {
                    str.append(currStr);
                    num--;
                }
                //append str to currStr
                currStr = str;
            }
            i++;
        }
        return currStr.toString();
    }
}
