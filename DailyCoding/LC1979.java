class Solution {
    public int findGCD(int[] nums) 
    {
        //find smallest and largest number
        //find gcd for that (reminder should be 0)
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int num:nums)
        {
            max = Math.max(max,num);
            min = Math.min(min,num);
        }
        int gcd = 0;
        for(int i=1;i<=min;i++)
        {
            if(max%i==0&&min%i==0)
            {
                gcd = i;
            }
        }
        return gcd;
    }
}
