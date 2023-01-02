package JavaDS.onedarray;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

// Time: O(n), Space: O(n)

public class subarraysum2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the length of the array");
        int a = sc.nextInt();
        System.out.println("enter the sum required");
        int b=sc.nextInt();
        int[] num = new int[a];
        for (int i = 0; i < a; i++)
            num[i] = sc.nextInt();
        checksum(num,b);
    }
    public static void checksum(int[] num,int b){
        //we are taking map to store array indexes of array values so that we can fetch index of a value in O(1)
        Map<Integer,Integer> c=new HashMap<>();
        int sum=0;
        for(int i=0;i<num.length;i++) {
            c.put(num[i],i);
        }
        for(int i=0;i<num.length;i++){
            if(c.containsKey(b-num[i]) && i!=c.get(b-num[i])) {
                System.out.println(i + " " + c.get(b - num[i]));
                c.remove(num[i]);
                c.remove(b-num[i]);
            }
        }
    }
}
