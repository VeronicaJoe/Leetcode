class Solution {
    public int maxProduct1(int n) 
    {
        List<Integer> list = new ArrayList<>();
        int max = Integer.MIN_VALUE;

        while(n!=0)
        {
            int digit = n%10;
            list.add(digit);
            n/=10;
        }    
        for(int i=0;i<list.size();i++)
        {
            for(int j=i+1;j<list.size();j++)
            {
                max = Math.max(max,list.get(i)*list.get(j));
            }
        }
        return max;
    }
    //Optimal: Get the maximum 2 digits
    public int maxProduct(int n)
    {
        int max1 = Integer.MIN_VALUE,max2 = Integer.MIN_VALUE;
        while(n!=0)
        {
            int digit = n%10;
            if(digit>max1)
            {
                max2=max1;
                max1=digit;
            }
            else if(digit>max2)
            {
                max2=digit;
            }
            n/=10;
        }
        return max1*max2;
    }
}
