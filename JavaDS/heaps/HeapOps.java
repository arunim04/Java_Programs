package JavaDS.heaps;

import java.util.ArrayList;
import java.util.Scanner;

public class HeapOps {
    public static void main(String args[]){
        ArrayList<Integer> al=new ArrayList<>();
        createMaxHeap(al);
        deleteFromMaxHeap(al);
    }

    // Time: O(n*log2(n)), Space: O(1)
    public static void createMaxHeap(ArrayList<Integer> al){
        Scanner sc=new Scanner(System.in);
        System.out.print("create max heap");
        System.out.print("enter the elements");
        int i=0;
        while (true){
            int n=sc.nextInt();
            if (n==-1) break;
            al.add(n);
            insertionHeapify(al);
        }
        System.out.println("\nMax Heap: ");
        for (int val: al) System.out.print(val + " ");
    }

    // Time: O(log2(n)), Space: O(1)
    public static void insertionHeapify(ArrayList<Integer> al){
        int i= al.size()-1;
        while (i>0){
            int parentIndex=(i-1)/2;
            if (al.get(i)>al.get(parentIndex)){
                int temp=al.get(i);
                al.set(i, al.get(parentIndex));
                al.set(parentIndex,temp);
                i=parentIndex;
            }
            else break;
        }
    }

    // Time: O(n*log2(n)), Space: O(1)
    public static void deleteFromMaxHeap(ArrayList<Integer> al){
        System.out.println("delete from max heap");
        for (int i=al.size()-1;i>=0;i--){
            System.out.println("removing"+al.get(0));
            al.set(0,al.get(i));
            al.remove(i);
            deletionHeapify(al,0,i);
        }
    }

    // Time: O(log2(n)), Space: O(1)
    public static void deletionHeapify(ArrayList<Integer> al,int i,int n){
        int maxIndex=i;
        while (i<n){
            int leftChildIndex=i*2+1;
            int rightChildIndex=i*2+2;
            if (leftChildIndex<n && al.get(leftChildIndex)>al.get(maxIndex))
                maxIndex=leftChildIndex;
            if (rightChildIndex<n && al.get(rightChildIndex)>al.get(maxIndex))
                maxIndex=rightChildIndex;
            if (maxIndex!=i){
                int temp=al.get(i);
                al.set(i,al.get(maxIndex));
                al.set(maxIndex,temp);
                i=maxIndex;
            }
            else break;
        }
    }
}
