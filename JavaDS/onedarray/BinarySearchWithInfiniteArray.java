package JavaDS.onedarray;

import java.util.Scanner;

// Time: O(log2(n)), Space: O(1)

public class BinarySearchWithInfiniteArray {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the length of array");
        int[] al=new int[sc.nextInt()];
        System.out.println("enter the elements");
        int i=0;
        while (i<al.length){
            al[i]=sc.nextInt();
            i++;
        }
        System.out.println("enter the no. to search");
        int index= binarysearchinfinite(al,sc.nextInt());
        if (index != -1) System.out.println(index);
        else System.out.println("Not found");
    }
    public static int binarysearchinfinite(int[] arr,int index){
        int l=0,r=1;
        while (arr[r]<index){
            l=r;
            r=2*r;
        }
        return BinarySearch.binarysearch(arr,l,r,index);
    }
}
