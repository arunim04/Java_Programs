package JavaDS.DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class LongestCommonSubsequence {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter string1:");
        String str1 = sc.nextLine();
        System.out.println("Enter string2:");
        String str2 = sc.nextLine();
        System.out.println("Longest common subsequence length: " + lcsWithoutDP(str1, str2));
        int[][] dp = new int[str1.length()][str2.length()];
        for (int i = 0; i < dp.length; i++)
            Arrays.fill(dp[i], -1);
        System.out.println("Lcs length (method-1 dp optimised): " + lcsWithDP(str1, str2, str1.length()-1, str2.length()-1, dp));
    }

    // Time: O(2^n), Space: O(n)
    static int lcsWithoutDP(String str1,String str2){
        if(str1.length()==0 || str2.length()==0)
            return 0;
        if(str1.charAt(str1.length()-1)==str2.charAt(str2.length()-1))
            return 1+lcsWithoutDP(str1.substring(0,str1.length()-1),str2.substring(0,str2.length()-1));
        else
            return Math.max(lcsWithoutDP(str1,str2.substring(0,str2.length()-1)),lcsWithoutDP(str1.substring(0,str1.length()-1),str2));
    }

    // Time: O(n*m), Space: O(n*m) - n: length of 1st string, m: length of 2nd string
    static int lcsWithDP(String str1,String str2,int m,int n,int[][] dp){
        if(m==-1 || n==-1)
            return 0;
        if(dp[m][n]!=-1)
            return dp[m][n];
        if(str1.charAt(m)==str2.charAt(n))
            return dp[m][n]=1+lcsWithDP(str1,str2,m-1,n-1,dp);
        else return dp[m][n]=Math.max(lcsWithDP(str1,str2,m-1,n,dp),lcsWithDP(str1,str2,m,n-1,dp));
    }

    // Time: O(n*m), Space: O(n*m)
    static void lcsWithDP2(String str1, String str2) {
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        System.out.println("Longest common subsequence length (method-2 dp optimised): " + dp[str1.length()][str2.length()]);
        String lcs = "";
        int i = dp.length-1, j = dp[0].length-1;
        while (i != 0 && j != 0) {
            if (dp[i][j] == dp[i][j-1])
                j--;
            else if (dp[i][j] == dp[i-1][j])
                i--;
            else {
                lcs = str1.charAt(i-1) + lcs;
                i--; j--;
            }
        }
        System.out.println("Longest common subsequence string (method-2 dp optimised): " + lcs);
    }

    // Time: O(n*m), Space: O(m)
    static int lcsWithDP2Opt(String str1, String str2) {
        int[] dpPrev = new int[str2.length()+1];
        int[] dpCur = new int[str2.length()+1];
        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i-1) == str2.charAt(j-1))
                    dpCur[j] = dpPrev[j-1] + 1;
                else
                    dpCur[j] = Math.max(dpPrev[j], dpCur[j-1]);
            }
            for (int k = 0; k < dpPrev.length; k++)
                dpPrev[k] = dpCur[k];
        }
        return dpCur[str2.length()];
    }
}
