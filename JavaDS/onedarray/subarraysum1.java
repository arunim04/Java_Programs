package JavaDS.onedarray;

import java.util.HashSet;
import java.util.Scanner;

// Time: O(n), Space: O(n)

public class subarraysum1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the length of the array");
        int a = sc.nextInt();
        System.out.println("enter the sum required");
        int b=sc.nextInt();
        int[] num = new int[a];
        for (int i = 0; i < a; i++)
            num[i] = sc.nextInt();
        System.out.println(checksum(num, a,b));
    }
    public static boolean checksum(int[] num,int a,int b){
        HashSet<Integer> c=new HashSet<>();
        int sum=0;
        for(int i=0;i<a;i++) {
            c.add(sum);
            sum=sum+num[i];
            if(c.contains(sum-b))
                return true;
        }
        return false;
    }
}

