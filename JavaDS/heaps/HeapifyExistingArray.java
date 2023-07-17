package JavaDS.heaps;

import java.util.Scanner;

// Time: O(n), Space: O(1)

public class HeapifyExistingArray {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the length of the array");
        int[] al=new int[sc.nextInt()];
        int i=0;
        System.out.println("enter the nos.");
        while (i<al.length){
            al[i]=sc.nextInt();
            i++;
        }
        heapifyExistingArray(al);
        System.out.print("Heapified array: ");
        for (int val: al) System.out.print(val + " ");
    }

    public static void heapifyExistingArray(int[] arr){
        for (int i=(arr.length-1)/2;i>=0;i--){
            heapify(arr,i,arr.length);
        }
    }

    public static void heapify(int[] arr,int i,int n){
        int maxIndex=i;
        while (i<n){
            int leftChildIndex=i*2+1;
            int rightChildIndex=i*2+2;
            if (leftChildIndex<n && arr[leftChildIndex]>arr[maxIndex])
                maxIndex=leftChildIndex;
            if (rightChildIndex<n && arr[rightChildIndex]>arr[maxIndex])
                maxIndex=rightChildIndex;
            if (maxIndex!=i){
                int temp=arr[i];
                arr[i]=arr[maxIndex];
                arr[maxIndex]=temp;
                i=maxIndex;
            }
            else break;
        }
    }
}
