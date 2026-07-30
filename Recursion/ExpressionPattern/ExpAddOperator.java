class Solution {
     List<String> list = new ArrayList<>();
    public List<String> addOperators(String num, int target) 
    {
        dfs(0,"",0,0,num,target);
        return list;
    }
    private void dfs(int start,String expression,long resultant,long prevNo,String num,int target)
    {
        //base case
        if(start==num.length())
        {
            if(resultant==target)
            list.add(expression);

            return;
        }

        //for loop backtracking - refer palindrome partition / word break
        for(int end=start;end<num.length();end++)
        {
            //leading zero
            //valid - "0"
            //invalid - "05","005","012"
            if(end>start&&num.charAt(start)=='0')
            break;

            String path = num.substring(start,end+1);
            long currNo = Long.parseLong(path);

            //first no
            if(start==0)
            {
                dfs(end+1,path,currNo,currNo,num,target);
            }
            else
            {
                //+
                dfs(end+1,expression+"+"+path,resultant+currNo,currNo,num,target);
                //-
                dfs(end+1,expression+"-"+path,resultant-currNo,-currNo,num,target);
                //x
                dfs(end+1,expression+"*"+path,resultant-prevNo+(prevNo*currNo),prevNo*currNo,num,target);
            }
        }
    }
}
