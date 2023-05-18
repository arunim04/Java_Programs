package JavaDS.numbers;
import java.util.*;

// Find the unique element in an array where all the repeated elements occur k times
// Can also do by XORing all the elements. But this solution would only work if k is even
// Time: O(n) - specifically its 32 * O(n), Space: O(1) - specifically it's 32 which is a constant

public class NonRepeatedNumberAmongKDuplicates {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no. of times the repeated numbers will be repeated: ");
        int k = sc.nextInt();
        if (k < 2) {
            System.out.println("k needs to be greater than 1");
            return;
        }
        System.out.println("Enter length of array:");
        int[] al = new int[sc.nextInt()];
        int i = 0;
        while (i < al.length) {
            System.out.println("Enter number: ");
            al[i] = sc.nextInt();
            i++;
        }
        System.out.print("Inputted array: ");
        for (int val: al) System.out.print(val + " ");
        System.out.println();
        nonRepeatingNumber(al, k);
    }

    public static void nonRepeatingNumber(int[] nums, int k) {
        int INT_SIZE = 8*4; // 4 bytes
        int[] bitsArr = new int[INT_SIZE];
        for (int i = 0; i < INT_SIZE; i++) {
            for (int j = 0; j < nums.length; j++) {
                if ((nums[j] & (1 << i)) != 0)
                    bitsArr[i] += 1;
            }
        }

        int uniqueNum = 0;
        for (int i = 0; i < INT_SIZE; i++) {
            uniqueNum += (bitsArr[i] % k) * (1 << i);
        }

        System.out.println("Non-repeated number: " + uniqueNum);
    }
}
