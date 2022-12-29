package JavaDS.numbers;

import java.util.Scanner;

// Time: O(log n), Space: O(1)

public class setbits {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("enter a no. to find nos. of set bits");
        int a=sc.nextInt();
        System.out.println(set(a));
    }
    public static int set(int n){
        int count=0,a;
        while(n!=0){
            a=n%2;
            n=n/2;
            if(a==1)
                count++;
        }
        return count;
    }
}
