class Solution {
    public double myPow1(double x, int n) 
    {
        double ans = 1;
        for(int i=0;i<n;i++)
        {
            ans*=x;
        }
        return ans;
        
    }
    //even pow: (x*x)^pow/2
    //odd pow: (x*x^pow-1)
    public double myPow(double x,int n)
    {
        long pow = n;
        if(n<0)
        {
            pow = -pow;
            x = 1/x;
        }
        return power(x,pow);
    }
    private double power(double x,long n)
    {
        //base case
        if(n==0)
        return 1;

        if(n%2==0)
        {
            return power(x*x,n/2);
        }
        return x*power(x*x,(n-1)/2);
    }
}
