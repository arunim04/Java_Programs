package JavaDS.numbers;

import java.util.Scanner;

public class exponent {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter base");
        int a = sc.nextInt();
        System.out.println("enter exponent");
        int b = sc.nextInt();
        System.out.println(expoo(a,b));
    }
    // Time: O(n), Space: O(1)
    public static int expo(int a,int b){
        int c=1;
        for(int i=1;i<=b;i++){
            c=c*a;
        }
        return c;
    }
    // Time: O(log n), Space: O(n)
    public static int expoo(int a,int b){
        if(b==0)
            return 1;
        if (b % 2 == 0)  //b%2 can be written as b&1
            return expoo(a * a, b / 2);  //b/2 can be written as b>>1
        return a * expoo(a, b-1);
    }
}
