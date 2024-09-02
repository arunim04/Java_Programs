package JavaDS.DynamicProgramming;

import java.util.Scanner;

public class MatrixChainMultiplication {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the no. of matrices");
        int[] arr=new int[sc.nextInt()+1];
        int n=arr.length;
        System.out.println(matrixchainDP(n,arr));
    }

    static int matrixchainDP(int n,int[] arr){
        int[][] dp=new int[n][n];
        for (int len=2;len<n;len++){
            int col=len;
            for (int row=0;row<n-len;row++){
                dp[row][col]=Integer.MAX_VALUE;
                for (int k=row+1;k<col;k++){
                    dp[row][col]=Math.min(dp[row][col],dp[row][k]+dp[k][col]+arr[row]*arr[k]*arr[col]);
                }
                col++;
            }
        }
        return dp[0][n-1];
    }
}
