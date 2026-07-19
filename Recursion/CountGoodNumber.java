class Solution {
    public int countGoodNumbers1(long n) 
    {
        //even indices (0,2,4,6,8)=5
        //odd indices (2,3,5,7)=4
        //power

        int mod  = (int)1e9+7;
        long cnt = 1;
        for(int i=0;i<n;i++)
        {
            if(i%2==0)
            {
                cnt = (cnt*5)%mod;
            }
            else
            {
                cnt = (cnt*4)%mod;
            }
        }    
        return (int)cnt;
    }
    final int MOD = (int)1e9+7;
    public int countGoodNumbers(long n)
    {
        //even index (0,2,4,6,8)
        //odd index (2,3,5,7)

        long evenPos = (n+1)/2;
        long oddPos = n/2;

        long evenCount = power(5,evenPos);
        long oddCount = power(4,oddPos);

        return (int)((evenCount*oddCount)%MOD);
    }
    private long power(long x,long n)
    {
        if(n==0)
        return 1;

        if(n%2==0)
        return power((x*x)%MOD,n/2);

        return (x*power((x*x)%MOD,(n-1)/2))%MOD;
    }


}
