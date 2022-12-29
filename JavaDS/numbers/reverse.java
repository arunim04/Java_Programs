package JavaDS.numbers;

import java.util.Scanner;

// Time: O(log n), Space: O(1)
public class reverse {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("enter a no. to find reverse");
        int a=sc.nextInt();
        System.out.println(rev(a));
    }
    public static int rev(int n){
        int m,r=0;
        while(n!=0){
            m=n%10;
            r=10*r+m;
            n=n/10;
        }
        return r;
    }
}
