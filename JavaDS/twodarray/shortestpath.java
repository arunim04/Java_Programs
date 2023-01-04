package JavaDS.twodarray;

import java.util.Scanner;

// Time: O(2^n), Space: O(m*n)

public class shortestpath {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the size of row");
        int a = sc.nextInt();
        System.out.println("enter the size of column");
        int b = sc.nextInt();
        int[][] arr=new int[a][b];
        System.out.println(path(arr,a,b));
    }
    public static int path(int[][] arr,int m,int n){
        if(m==1 || n==1)
            return 1;
        return path(arr,m-1,n)+path(arr,m,n-1);
    }
}
