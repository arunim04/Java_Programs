package JavaDS.onedarray;

import java.util.Scanner;
//Time: O(n^2)

public class BubbleSort {
    public static void main(String args[]){
        System.out.println("enter the size of array");
        Scanner sc=new Scanner((System.in));
        int n=sc.nextInt();
        int[] al=new int[n];
        System.out.println("enter the elements");
        for (int i=0;i<al.length;i++){
            al[i]= sc.nextInt();
        }
        bubblesort(al,n);
    }
    public static void bubblesort(int[] array,int a){
        for(int i=0;i<a;i++){
            boolean swap=false;
            for(int j=0;j<a-i-1;j++){
                if(array[j]>array[j+1]){
                    swap=true;
                    int temp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                }
            }
            if (!swap)
                break;
        }
        for (int i = 0; i < array.length; i++)
            System.out.print(array[i] + " ");
        System.out.println();
    }
}
