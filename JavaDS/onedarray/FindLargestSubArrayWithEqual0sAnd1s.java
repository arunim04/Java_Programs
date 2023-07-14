package JavaDS.onedarray;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Time: O(n), Space: O(n)

public class FindLargestSubArrayWithEqual0sAnd1s {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter length of array:");
        int[] al = new int[sc.nextInt()];
        int i = 0;
        System.out.println("Enter number: ");
        while (i < al.length) {
            al[i] = sc.nextInt();
            i++;
        }
        System.out.println("Max sub-array length with equal 1s & 0s: " + findLargestSubArrayWithEqual1sAnd0s(al));
    }

    public static int findLargestSubArrayWithEqual1sAnd0s(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int sum = 0, maxLength = 0;
        map.put(0,-1);
        for (int i = 0; i < nums.length; i++) {
            sum = sum + (nums[i] == 1 ? 1 : -1);
            if (!map.containsKey(sum))
                map.put(sum,i);
            else {
                int length = i - map.get(sum);
                maxLength = Math.max(maxLength, length);
            }
        }
        return maxLength;
    }
}
