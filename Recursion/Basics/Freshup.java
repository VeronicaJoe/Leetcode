package Recursion.Lec1;

public class Revision
{
    //Printing name 5 times - Using a global variable
    int cnt = 0;
    private void printName(String name)
    {
        if(cnt==5)
            return;
        System.out.println(name);
        cnt++;
        printName(name);
    }
    //Printing name 5 times - without global variable
    private void printName1(String name,int cnt)
    {
        if(cnt==0)
            return;
        System.out.println(name);
        cnt--;
        printName1(name,cnt);
    }
    //print nums [1-n](TOP - DOWN)
    private void printNum1(int cnt,int num)
    {
        if(cnt>num)
            return;
        System.out.println(cnt);
        cnt++;
        printNum1(cnt,num);
    }
    //print nums [n-1](TOP - DOWN)
    private void printNum2(int num)
    {
        if(num==0)
            return;

        System.out.println(num);
        num--;
        printNum2(num);
    }
    //print nums [1-n](BOTTOM - UP)
    //num = 3
    //3 2 1 0(return)
    private void printNum3(int num)
    {
        if(num==0)
            return;
        printNum3(num-1);
        System.out.println(num);
    }
    //print nums [n-1](bottom - up)
    //5 4 3 2 1
    //1 2 3 4 5
    private void printNum4(int num,int cnt)
    {
        if(cnt>num)
            return;
        printNum4(num,cnt+1);
        System.out.println(cnt);
    }
    //Parameterized Recursion
    private void printSum1(int num,int sum)
    {
        if(num<1)
        {
            System.out.println("Sum: "+sum);
            return;
        }
        printSum1(num-1,sum+num);
    }
    //Functional Recursion
    private int printSum2(int num)
    {
        if(num<1)
            return 0;
        return num + printSum2(num-1);
    }
    public static void main(String[] args)
    {
        Revision obj = new Revision();
        System.out.println("Printing name 5 times(using global var");
        obj.printName("Veronica");
        System.out.println("Printing name 5 times(w/o using global var)");
        obj.printName1("verojoe_03",5);
        System.out.println("Print nums from 1 -> n[top down]");
        obj.printNum1(1,5);
        System.out.println("Print nums from n -> 1[top-down]");
        obj.printNum2(5);
        System.out.println("Print nums from 1 -> n[bottom-up]");
        obj.printNum3(5);
        System.out.println("Print nums from n -> 1[bottom-up]");
        obj.printNum4(5,1);
        obj.printSum1(5,0);
        System.out.println("print sum using functional recursion: "+obj.printSum2(5));
    }
}

