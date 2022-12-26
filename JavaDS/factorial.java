package JavaDS;
import java.util.*;
public class factorial {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("enter a no. to find factorial");
        int a=sc.nextInt();
        System.out.println(fact(a));
    }

    public static int fact(int n){
        if(n<=1)
            return 1;
        return fact(n-1)*n;
    }
}

