package JavaDS;

import java.util.Scanner;

// Time: O(log min(a,b)), Space: O(1)

public class gcd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter a and b to find gcd");
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(div(a,b));
    }
    public static int div(int a,int b){
        int c;
        while(a%b!=0){
            c=a%b;
            a=b;
            b=c;
        }
        return b;
    }
}
