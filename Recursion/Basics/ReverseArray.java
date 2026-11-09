class Solution {
    //Recursion using 2 ptr
    public void reverseArray1(int arr[]) {
        // code here
        int left = 0, right = arr.length-1;
        reverse(arr,left,right);
    }
    //Recursion using 1 ptr
    public void reverseArray(int arr[]) {
        int ind = 0;
        reverse1(ind,arr);
    }
    private void reverse1(int ind,int[] arr)
    {
        if(ind>=arr.length/2)
        return;
        
        swap(arr,ind,arr.length-ind-1);
        reverse1(ind+1,arr);
    }
    private void reverse(int[] arr,int left,int right)
    {
        if(left>=right)
        return;
        swap(arr,left,right);
        reverse(arr,left+1,right-1);
    }
    private void swap(int[] arr,int left, int right)
    {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
