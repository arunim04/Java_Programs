package JavaDS.onedarray;

import java.util.Scanner;
//Time: O(n^2)

public class InsertionSort {
    public static void main(String args[]){
        System.out.println("enter the size of array");
        Scanner sc=new Scanner(System.in);
        int n= sc.nextInt();
        System.out.println("enter the elemnets");
        int[] arr=new int[n];
        for (int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        insertionsort(arr,n);
    }
    public static void insertionsort(int[] arr,int n){
        for (int i=0;i<n;i++){
            int temp=arr[i];
            int j=i-1;
            while (j>=0 && arr[j]>temp){
                arr[j+1]=arr[j];
                j=j-1;
            }
            arr[j+1]=temp;
        }
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}
