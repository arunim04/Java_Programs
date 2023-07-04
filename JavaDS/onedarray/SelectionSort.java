package JavaDS.onedarray;

import java.util.Scanner;
//Time: O(n^2)

public class SelectionSort {
    public static void main(String args[]){
        System.out.println("enter the size of array");
        Scanner sc=new Scanner(System.in);
        int n= sc.nextInt();
        System.out.println("enter the elemnets");
        int[] arr=new int[n];
        for (int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        selectionsort(arr,n);
    }
    public static void selectionsort(int[] arr,int n){
        for(int i=0;i<n-1;i++){
            int minindex=i;
            for (int j=i+1;j<n;j++){
                if(arr[j]<arr[minindex])
                    minindex=j;
            }
            if(minindex!=i){
                arr[i]=arr[i]^arr[minindex];
                arr[minindex]=arr[i]^arr[minindex];
                arr[i]=arr[i]^arr[minindex];
            }
        }
        System.out.println("Sorted array: ");
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }
}
