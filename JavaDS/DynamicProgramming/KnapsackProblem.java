package JavaDS.DynamicProgramming;

import java.util.Scanner;

public class KnapsackProblem {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter length of array:");
        int n = sc.nextInt();
        int[] weights = new int[n+1];
        int[] values = new int[n+1];
        int i = 1;
        while (i <= n) {
            System.out.println("Enter weight: ");
            weights[i] = sc.nextInt();
            System.out.println("Enter value: ");
            values[i] = sc.nextInt();
            i++;
        }
        System.out.println("\nEnter knapsack capacity:");
        int capacity = sc.nextInt();
        System.out.println("Max value that can be stored: " + maxValue(weights, values, capacity));
    }

    // Time: O(n*m), Space: O(n*m) - n: no. of different weights, m: total capacity of knapsack
    static int maxValue(int[] weights,int[] values,int capacity){
        int dp[][]=new int[weights.length][capacity+1];
        if(capacity==0) return 0;
        int i,j=0;
        for(i=1;i<weights.length;i++){
            for(j=1;j<capacity;j++){
                if(weights[i]<=j){
                    dp[i][j]=Math.max(values[i]+dp[i-1][j-weights[i]],dp[i-1][j]);
                }
                else
                    dp[i][j]=dp[i-1][j];
            }
        }
        return dp[i-1][j-1];
    }

    // Time: O(n*m), Space: O(m) - n: no. of different weights, m: total capacity of knapsack
    static int maxValueOpt(int[] weights, int[] values, int capacity) {
        int[] dp = new int[capacity+1];
        if (capacity == 0) return 0;
        int i, c;
        for (i = 1; i < weights.length; i++) {
            for (c = capacity; c >= 1; c--) {
                if (weights[i] <= c)
                    dp[c] = Math.max(dp[c], values[i] + dp[c-weights[i]]);
            }
        }
        return dp[capacity];
    }
}
