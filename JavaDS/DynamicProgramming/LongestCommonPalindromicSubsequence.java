package JavaDS.DynamicProgramming;

import java.util.Scanner;

// Time: O(n*m), Space: O(m)
public class LongestCommonPalindromicSubsequence {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter string1:");
        String str1=sc.nextLine();
        lcsPalindromic(str1);
    }

    static void lcsPalindromic(String str1){
        String str2="";
        for(char c:str1.toCharArray()){
            str2=c+str2;
        }
        System.out.println("Longest common palindromic seq lenght is"+LongestCommonSubsequence.lcsWithDP2Opt(str1,str2));
    }
}
