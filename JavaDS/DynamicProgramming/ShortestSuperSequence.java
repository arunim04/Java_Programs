package JavaDS.DynamicProgramming;

import java.util.Scanner;

// Time: O(n*m), Space: O(m)
public class ShortestSuperSequence {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter string 1:");
        String str1=sc.nextLine();
        System.out.println("Enter string 2:");
        String str2=sc.nextLine();
        shortestSuperSequence(str1,str2,LongestCommonSubsequence.lcsWithDP2Opt(str1,str2));
    }

    static void shortestSuperSequence(String str1,String str2,int lcslength){
        System.out.printf("Shortest super sequence of %s and %s:%d",str1,str2,(str1.length()+str2.length()-lcslength));
    }
}
