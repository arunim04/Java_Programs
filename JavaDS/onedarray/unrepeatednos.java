package JavaDS.onedarray;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class unrepeatednos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the size of array");
        int a = sc.nextInt();
        System.out.println("enter the nos.");
        int[] arr = new int[a];
        for (int i = 0; i < a; i++) {
            arr[i] = sc.nextInt();
        }
        unrepeated(arr,a);
    }
    public static void unrepeated(int[] arr,int n){
        Map<Integer,Integer> c=new HashMap<>();
        for(int i=0;i<n;i++) {
            if(c.containsKey(arr[i]))
                c.put(arr[i],c.get(arr[i])+1);
            else
                c.put(arr[i],1);
        }
        for(int i=0;i<n;i++)
            if(c.get(arr[i])==1)
                System.out.println(arr[i]);
    }
}
