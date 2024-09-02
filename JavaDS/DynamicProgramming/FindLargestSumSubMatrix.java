package JavaDS.DynamicProgramming;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class FindLargestSumSubMatrix {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter # rows for 2-d array:");
        int rows = sc.nextInt();
        System.out.println("Enter # cols for 2-d array:");
        int cols = sc.nextInt();
        int[][] al = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            System.out.println("Enter values for row: " + i);
            for (int j = 0; j < cols; j++) {
                System.out.println("Enter value for col: " + j);
                al[i][j] = sc.nextInt();
            }
        }
        largestSumSubMatrixWithDP(al);
    }

    // Time: O(m * m * n), Space: O(n) - n: no. of rows, m: no. of cols
    static void largestSumSubMatrixWithDP(int[][] al){
        int[] colCumulativeVals=new int[al.length];
        int largestSum=Integer.MIN_VALUE;
        for (int i=0;i<al[0].length;i++){
            Arrays.fill(colCumulativeVals,0);
            for (int j=0;j<al[0].length;j++){
                int curSum=0;
                for (int k=0;k< al.length;k++){
                    colCumulativeVals[k]=colCumulativeVals[k]+al[k][j];
                    curSum+=colCumulativeVals[k];
                    if(curSum>largestSum)
                        largestSum=curSum;
                    if(curSum<0)
                        curSum=0;
                }
            }
        }
        System.out.println("largest sum"+largestSum);
    }
}
