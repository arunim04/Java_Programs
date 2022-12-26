package JavaDS;

import java.util.Scanner;

// Time: O(log n), Space: O(1)
public class palindrome {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("enter a no. to find if it's palindrome");
        int a=sc.nextInt();
        System.out.println(pal(a));
    }
    public static boolean pal(int n){
        int m,r=0;
        while(r<n) {
            m = n % 10;
            r = 10 * r + m;
            n = n / 10;
        }
        if(r==n || n==r/10){
            return true;
        }
        return false;
    }
}
