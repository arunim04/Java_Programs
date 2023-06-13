package JavaDS.numbers;
import java.util.Scanner;

// Time: O(n), Space: O(n)

public class JosephusProb {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the no. of people");
        int n=sc.nextInt();
        System.out.println("enter the targeted person value");
        int k=sc.nextInt();
        System.out.println(jos(n,k));
    }
    public static int jos(int n,int k){
        if(n==1)
            return 0;
        return ((jos(n-1,k)+k)%n);
    }
}
