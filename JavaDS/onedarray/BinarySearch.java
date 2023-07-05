package JavaDS.onedarray;

import java.util.Scanner;

// Time: O(log2(n)), Space: O(1)

public class BinarySearch {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the length of the sorted array");
        int[] al=new int[sc.nextInt()];
        System.out.println("enter the no.");
        int i=0;
        while (i<al.length){
            al[i]=sc.nextInt();
            i++;
        }
        System.out.println("enter the no. to be seached");
        int index=binarysearch(al,0,al.length-1,sc.nextInt());
        if (index != -1) System.out.println(index);
        else System.out.println("Not found");
    }
    public static int binarysearch(int[] arr,int l,int h,int key){
        while (l<=h){
            int m=(l+h)/2;
            if(arr[m]==key)
                return m;
            if(arr[m]<key)
                l=m+1;
            else h=m-1;
        }
        return -1;
    }
}
