package JavaDS;

import java.util.Scanner;

public class fibonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter a no. to find if it's fibonacci");
        int a = sc.nextInt();
        System.out.println(fiboo(a));
    }

    // Time: O(2^n), Space: O(n) (if we consider stack length of function calls)
    public static int fibo(int n){
        if(n<=1)
            return n;
        else
            return fibo(n-1)+fibo(n-2);
    }

    // Time: O(n), Space: O(1)
    public static int fiboo(int n){
        int a=0,b=1,c=0;
        if(n<=1)
            return n;
        for(int i=2;i<=n;i++){
            c=a+b;
            a=b;
            b=c;
        }
        return c;
    }
}
