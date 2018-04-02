//
//Abdullah S. Alajaj
//OS3653 - PP1 
//02/19/2017
package pp1javaalajaj;

import java.util.*;
class X extends Thread{
public void run()
{ Main.arr[0]=0;
Main.arr[1]=1;
for(int i=2;i<Main.n;i++)
{
Main.arr[i]=Main.arr[i-1]+Main.arr[i-2];
}
}
}
public class Main {
static int n;
static int arr[]=new int[100];
public static void main(String args[])
{
System.out.println("enter the number of fibbonacci series length :");
Scanner sc=new Scanner(System.in);
String str=sc.nextLine();
n=Integer.parseInt(str);
X thread1=new X();
thread1.start();
try{
thread1.join();
}
catch(Exception e)
{
}
System.out.println("the fibbonacci series numbers are:");
for(int i=0;i<n;i++)
System.out.println(arr[i]);
}

}



