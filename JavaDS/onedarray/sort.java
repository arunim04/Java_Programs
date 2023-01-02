package JavaDS.onedarray;

import java.util.Scanner;

public class sort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the no. of elements");
        int a=sc.nextInt();
        System.out.println("enter the elements");
        int[] arr=new int[a];
        for(int i=0;i<a;i++)
            arr[i]= sc.nextInt();
//        bubsort(arr,a);
        selsort(arr,a);
        for(int i=0;i<a;i++)
            System.out.println(arr[i]);
    }
    public static void bubsort(int[] array,int n){
        int i,j,temp;
        for(i=n-1;i>0;i--) {
            for (j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
    public static void selsort(int[] array,int n){
        int pos,temp;
        for (int i = 0; i < n - 1; i++) {
            pos=i;
            for(int j=i+1;j<n;j++) {
                if (array[j] < array[pos])
                    pos = j;
                System.out.println("pos="+pos);
            }
            temp = array[i];
            array[i] = array[pos];
            array[pos] = temp;
        }
    }
}
