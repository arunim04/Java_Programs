package JavaDS.DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class CoinChangeProblem {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the length array");
        int[] al = new int[sc.nextInt()];
        int i = 0;
        while (i < al.length) {
            System.out.println("Enter coin value: ");
            al[i] = sc.nextInt();
            i++;
        }
        System.out.println("Enter value to be achieved from the coins:");
        int valReq = sc.nextInt();
        System.out.println("Min coins needed: " + minCoinsNeededWithoutDP(al, valReq));
        int[] dp = new int[valReq+1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        System.out.println("Min coins needed (optimised): " + minCoinsNeededWithDP(al, dp, valReq));
    }

    // Time:  O(m^n), Space:  O(n)
    static int minCoinsNeededWithoutDP(int[] al,int valReq){
        if(valReq==0) return 0;
        int res=Integer.MAX_VALUE;
        for(int i=0;i<al.length;i++){
            if(valReq-al[i]>=0) {
                int subAns = minCoinsNeededWithoutDP(al, valReq - al[i]);
                res = Math.min(res, subAns + 1);
            }
        }
        return res;
    }

    // Time: O(m*n), Space: O(n)
    static int minCoinsNeededWithDP(int[] al,int[] dp,int valReq){
        if(valReq==0) return 0;
        int res=Integer.MAX_VALUE;
        for(int i=0;i<al.length;i++){
            if(valReq-al[i]>=0){
                int subRes;
                if(dp[valReq-al[i]]!=-1){
                    subRes=dp[valReq-al[i]];
                }
                else
                    subRes=minCoinsNeededWithoutDP(al,valReq-al[i]);
                res=Math.min(res,subRes+1);
            }
        }
        return dp[valReq]=res;
    }
}
