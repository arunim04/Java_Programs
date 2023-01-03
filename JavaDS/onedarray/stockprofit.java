package JavaDS.onedarray;

import java.util.Scanner;

// Time: O(n), Space: O(1)

public class stockprofit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the no. of days");
        int a = sc.nextInt();
        System.out.println("enter the stock prices");
        int[] arr=new int[a];
        for(int i=0;i<a;i++){
            arr[i]= sc.nextInt();
        }
        System.out.println(maxpro(arr,a));
    }
    public static int maxpro(int[] arr,int n){
        int maxprofit=0;
        for(int i=1;i<n;i++){
            if(arr[i]>arr[i-1])
                maxprofit+=arr[i]-arr[i-1];
        }
        return maxprofit;
    }
}
