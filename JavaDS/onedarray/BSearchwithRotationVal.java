package JavaDS.onedarray;

// Time: O(log2(n)), Space: O(1)

import java.util.Scanner;

public class BSearchwithRotationVal {
    public static void main (String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter length of rotated sorted array:");
        int[] al = new int[sc.nextInt()];
        int i = 0;
        while (i < al.length) {
            System.out.println("Enter number: ");
            al[i] = sc.nextInt();
            i++;
        }
        System.out.print("Inputted array: ");
        for (int val : al) System.out.print(val + " ");
        System.out.println();
        System.out.print("Enter rotation value: ");
        int k = sc.nextInt();
        System.out.print("Enter number to search: ");
        int index = binarySearchRotated(al, 0, al.length - 1, k, sc.nextInt());

        if (index != -1) System.out.println(index);
        else System.out.println("Not found");
    }

    public static int binarySearchRotated(int[] nums, int l, int r, int rotation, int key) {
        while (l <= r) {
            int m = (l + r) / 2;
            int actual_m = (m + rotation) % nums.length;
            if (nums[actual_m] == key)
                return actual_m;
            if (nums[actual_m] < key) {
                l = (m + 1) % nums.length;
            } else {
                r = m - 1;
                if (r < 0) r = nums.length - 1;
            }
        }
        return -1;
    }
}
