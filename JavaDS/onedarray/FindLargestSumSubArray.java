package JavaDS.onedarray;

import java.util.Scanner;

// Kadane's algorithm
// Time: O(n), Space: O(1)

public class FindLargestSumSubArray {
    public  static void main(String args[]){
        try{
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter the length of the array");
            int[] al =new int[sc.nextInt()];
            int i=0;
            while (i<al.length){
                System.out.println("enter the no.");
                al[i]=sc.nextInt();
                i++;
            }
            System.out.print("Inputted array: ");
            for (int val: al) System.out.print(val + " ");
            System.out.println();
            largestSumSubArray(al);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
    public static void largestSumSubArray(int[] nums){
        int largestSum=Integer.MIN_VALUE;
        int curSum=0;
        for (int i=0;i< nums.length;i++){
            curSum+=nums[i];
            if(curSum>largestSum){
                largestSum=curSum;
            }
            if(curSum<0)
                curSum=0;
        }
        System.out.println("largest sum is"+largestSum);
    }
}
