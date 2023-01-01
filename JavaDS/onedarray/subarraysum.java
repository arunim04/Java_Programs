package JavaDS.onedarray;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

// Time: O(log n), Space: O(n)

public class subarraysum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the length of the array");
        int a = sc.nextInt();
        int[] num=new int[a];
        for(int i=0;i<a;i++)
            num[i]=sc.nextInt();
        System.out.println(checksum(num,a));
    }
    public static boolean checksum(int[] num,int a){
        HashSet<Integer> b=new HashSet<>();
        int sum=0;
        for(int i=0;i<a;i++) {
            b.add(sum);
            sum=sum+num[i];
            if(b.contains(sum))
                return true;
        }
        return false;
    }
}
