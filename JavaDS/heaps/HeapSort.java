package JavaDS.heaps;

import java.util.Scanner;

import static JavaDS.heaps.HeapifyExistingArray.heapify;

// Time: O(n*log2(n)), Space: O(1)

public class HeapSort {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the length of the array");
        int[] al=new int[sc.nextInt()];
        System.out.println("enter the no.");
        int i=0;
        while (i<al.length){
            al[i]=sc.nextInt();
            i++;
        }
        heapSort(al);
        System.out.println("Sorted array:");
        for (int val:al) System.out.println(val+"");
    }

    public static void heapSort(int[] arr){
        for (int i=(arr.length-1)/2;i>=0;i--){
            heapify(arr,i,arr.length);
        }
        for (int i=arr.length-1;i>0;i--){
            int temp=arr[0];
            arr[0]=arr[i];
            arr[i]=temp;
            heapify(arr,0,i);
        }
    }
}
