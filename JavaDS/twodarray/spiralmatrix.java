package JavaDS.twodarray;

// Time: O(m*n), Space: O(1)

import java.util.Scanner;

public class spiralmatrix {
    public static void spiral(int a[][], int m,int n){
        int i,k=0,l=0;
        //k - starting row index
        //l - starting column index
        while(k<m && l<n){
            for(i=l;i<n;i++){
                System.out.print(a[k][i]+" ");
            }
            k++;
            for(i=k;i<m;i++){
                System.out.print(a[i][m-1]+" ");
            }
            n--;
            if(k<m){
                for(i=n-1;i>=l;i--){
                    System.out.print(a[m-1][i]+" ");
                }
                m--;
            }
            if(l<n){
                for(i=m-1;i>=k;i--){
                    System.out.print(a[i][l]+" ");
                }
                l++;
            }
        }
    }

    public static void main(String args[]){
        int a[][] = { { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        int m=4;
        int n=4;

        spiral(a,m,n);
    }
}
