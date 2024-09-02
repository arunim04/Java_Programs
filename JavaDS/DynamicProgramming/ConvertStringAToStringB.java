package JavaDS.DynamicProgramming;

import java.util.Scanner;

// Time: O(n*m), Space: O(m)
public class ConvertStringAToStringB {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter string1:");
        String str1=sc.nextLine();
        System.out.println("Enter string2:");
        String str2=sc.nextLine();
        minInsertionsDeletions(str1,str2,LongestCommonSubsequence.lcsWithDP2Opt(str1,str2));
    }

    static void minInsertionsDeletions(String str1,String str2,int lcsLength){
        System.out.printf("To convert %s to %s:\n",str1,str2);
        System.out.println("Min deletions needed"+(str1.length()-lcsLength));
        System.out.println("Min insertions needed"+(str2.length()-lcsLength));
    }
}
