package JavaDS.onedarray;

import java.util.Scanner;
//Time: O(n^2)

public class QuickSort {
    public static void main(String args[]){
        System.out.println("enter the size of array");
        Scanner sc=new Scanner(System.in);
        int n= sc.nextInt();
        System.out.println("enter the elements");
        int[] arr=new int[n];
        for (int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        quicknsort(arr,0,n-1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    static int partition(int[] arr, int low, int high)
    {
        int pivot=arr[low];
        int i=low;
        int j=high;
        while(i<j){
            while (arr[i]<=pivot)i++;
            while (arr[j]>pivot)j--;
            if(i<j){
                swap(arr,i,j);
            }
        }
        swap(arr,low,j);
        return j;
    }

    public static void quicknsort(int[] arr,int low,int high){
        if(low<high){
            int pivot=partition(arr,low,high);
            quicknsort(arr,low,pivot-1);
            quicknsort(arr,pivot+1,high);
        }
    }
}
