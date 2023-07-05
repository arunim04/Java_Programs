package JavaDS.onedarray;

import java.util.Scanner;

public class MergeSort {
    public static void main(String args[]){
        System.out.println("enter the size of array");
        Scanner sc=new Scanner(System.in);
        int n= sc.nextInt();
        System.out.println("enter the elements");
        int[] arr=new int[n];
        for (int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        mergesort(arr,0,n-1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    public static void mergesort(int[] arr,int l,int r){
        if (l<r){
            int mid=(l+r)/2;
            mergesort(arr,l,mid);
            mergesort(arr,mid+1,r);
            merge(arr,l,mid,r);
        }
    }

    public static void merge(int[] arr,int l,int mid,int r){
//        int[] b=new int[100];
//        int i=l;
//        int j=mid+1;
//        int k=l;
//        while (j<=mid && j<=r){
//            if (arr[i]<arr[j]){
//                b[k]=arr[i];
//                i++;
//            }
//            else {
//                b[k] = arr[j];
//                j++;
//            }
//            k++;
//        }
//        if(i>mid){
//            while(j<=r){
//                b[k]=arr[j];
//                k++;
//                j++;
//            }
//        }
//        else {
//            while (i<=mid){
//                b[k]=arr[i];
//                k++;
//                i++;
//            }
//        }
//        for (k=l;k<=r;k++)
//            arr[k]=b[k];
        int n1 = mid - l + 1;
        int n2 = r - mid;
        int L[] = new int[n1];
        int R[] = new int[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[mid + 1 + j];
        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        // Copy remaining elements of L[] if any
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        // Copy remaining elements of R[] if any
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}
