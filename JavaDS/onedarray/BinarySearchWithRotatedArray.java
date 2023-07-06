package JavaDS.onedarray;

import java.util.Scanner;

public class BinarySearchWithRotatedArray {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter length of rotated sorted array:");
        int[] al = new int[sc.nextInt()];
        int i = 0;
        while (i < al.length) {
            System.out.println("Enter number: ");
            al[i] = sc.nextInt();
            i++;
        }
        System.out.print("Enter number to search: ");
        int index = binarySearchRotated(al,0,al.length-1,sc.nextInt());
        if (index != -1) System.out.println(index);
        else System.out.println("Not found");
    }

    public static int binarySearchRotated(int[] arr,int l,int r,int key){
        while (l<=r){
            int m=(l+r)/2;
            if(arr[m]==key)
                return m;
            if (arr[l]<arr[m]){
                if (arr[l]<=key && key<arr[m])
                    r=m-1;
                else l=m+1;
            }
            else {
                if (arr[m]<key && key<=arr[r])
                    l=m+1;
                else r=m-1;
            }
        }
        return -1;
    }
}
