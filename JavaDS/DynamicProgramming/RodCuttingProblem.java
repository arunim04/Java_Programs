package JavaDS.DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class RodCuttingProblem {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the length of rod");
        int[] values=new int[sc.nextInt()];
        int i=1;
        while (i<values.length){
            System.out.println("Enter the value for rod length"+i+":");
            values[i]= sc.nextInt();
            i++;
        }
        System.out.println("inputted array:");
        for (int val: values) System.out.print(val + " ");
        System.out.println();
        int[] dp = new int[values.length];
        Arrays.fill(dp, -1);
        System.out.println("Max value from cutting the rod of length " + (values.length-1) + " (method-1 dp optimised): " + maxValWithDP(values, values.length-1, dp));
    }

    // Time: O(n^2), Space: O(n)
    static int maxValWithDP(int[] values,int length,int[] dp){
        if (length==0)
            return 0;
        int maxval=Integer.MIN_VALUE;
        for (int i=1;i<=length;i++){
            if (dp[length-i]!=1){
                maxval=Math.max(maxval,values[i]+values[length-i]);
            }
            else maxval=Math.max(maxval,values[i]+maxValWithDP(values,length-i,dp));
        }
        dp[length]=maxval;
        return maxval;
    }

    // Time: O(n^2), Space: O(n)
    static int maxValWithDP2(int[] values){
        int dp[]=new int[values.length];
        for(int i=1;i<=values.length;i++){
            for (int j=0;j<=i;j++){
                dp[i]=Math.max(dp[i],values[j]+dp[i-j]);
            }
        }
        return dp[dp.length-1];
    }
}
