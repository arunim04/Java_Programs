package JavaDS.DynamicProgramming;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class ConvertStringAToStringBMinOpsCount2 {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter source string");
        String sourceStr=sc.nextLine();
        System.out.println("Enter target string");
        String targetStr=sc.nextLine();
        int[][] dp=new int[sourceStr.length()][targetStr.length()];
        for (int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
        System.out.printf("\nMin operations to convert %s to %s: %d",sourceStr, targetStr, minOpsWithDP(sourceStr, targetStr,sourceStr.length()-1, targetStr.length()-1, dp));
    }

    // Time: O(n*m), Space: O(n*m)
    static int minOpsWithDP(String sourceStr,String targetStr,int m,int n,int[][] dp){
        if(m==-1) return n+1;
        if(n==-1) return m+1;
        if(dp[m][n]!=Integer.MIN_VALUE) return dp[m][n];
        if (sourceStr.charAt(m) == targetStr.charAt(n))
            return dp[m][n]=minOpsWithDP(sourceStr,targetStr,m-1,n-1,dp);
        else{
            int case1=1+minOpsWithDP(sourceStr,targetStr,m,n-1,dp);
            int case2=1+minOpsWithDP(sourceStr,targetStr,m-1,n,dp);
            int case3=1+minOpsWithDP(sourceStr,targetStr,m=1,n-1,dp);
            return dp[m][n]=Math.min(case1,Math.min(case2,case3));
        }
    }

    // Time: O(n*m), Space: O(n*m)
    static int minOpsWithDP2(String sourceStr,String targetStr){
        int[][] dp=new int[sourceStr.length()+1][targetStr.length()+1];
        for (int i=0;i<dp.length;i++)
            dp[i][0]=i;
        for (int j=0;j<dp[0].length;j++)
            dp[0][j]=j;
        for (int i=1;i<sourceStr.length();i++){
            for (int j=1;j<targetStr.length();j++){
                int minOps=Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]));
                if(sourceStr.charAt(i-1)==targetStr.charAt(j-1))
                    dp[i][j]=minOps;
                else
                    dp[i][j]=1+minOps;
            }
        }
        return dp[sourceStr.length()][targetStr.length()];
    }
}
