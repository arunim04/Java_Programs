package JavaDS.onedarray;

import java.util.Scanner;

// Moore's voting algorithm
// Time: O(n), Space: O(1)

public class MajorityInArray {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the length of array");
        int[] al=new int[sc.nextInt()];
        int i=0;
        while(i< al.length){
            System.out.println("enter the no.");
            al[i]=sc.nextInt();
            i++;
        }
        System.out.println("Inputted array is:");
        for (int val:al) System.out.println(val+"");
        System.out.println();
        majority(al);
    }

    public static void majority(int[] nums){
        int majorityNum=nums[0];
        int weight=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]==majorityNum)
                weight+=1;
            else{
                weight-=1;
                if(weight==0){
                    majorityNum=nums[i];
                    weight=1;
                }
            }
        }
        int count=0;
        for (int i=0;i<nums.length;i++){
            if(nums[i]==majorityNum)
                count++;
        }
        if(count>nums.length/2)
            System.out.println("majority element"+majorityNum);
        else System.out.println("no majority element found");
    }
}
