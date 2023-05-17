package JavaDS.numbers;
import java.util.Scanner;

// 1. Find ith bit of a number
// 2. Set ith bit of a number
// 3. Unset ith bit of a number
// 4. Find total set bits of a number
// 5. Find total set bits of a number (optimised method)

public class BitOps {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number: ");
        int n = sc.nextInt();
        findIthBit(n);
        setIthBit(n);
        unsetIthBit(n);
        System.out.println();
        System.out.printf("Set bits count in %d is: %d\n", n, setBits(n));
        System.out.printf("Set bits count in %d is: %d\n", n, setBitsOpt(n));
    }

    // Time: O(1), Space: O(1)
    public static void findIthBit(int n) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the position to find the bit at: ");
        int i = sc.nextInt();
        int ithBit = (n >> i) & 1;
        System.out.printf("Bit at the position %s in the number %s is: %s\n", i, n, ithBit);
    }

    // Time: O(1), Space: O(1)
    public static void setIthBit(int n) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the position to set the bit at: ");
        int i = sc.nextInt();
        n = n | (1 << i);
        System.out.printf("Number after setting bit at the position %s is: %s\n", i, n);
    }

    // Time: O(1), Space: O(1)
    public static void unsetIthBit(int n) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the position to unset the bit at: ");
        int i = sc.nextInt();
        n = n & ~(1 << i);
        System.out.printf("Number after unsetting bit at the position %s is: %s\n", i, n);
    }

    // Time: O(log2(n)) and avg case is also O(log2(n)), Space: O(1)
    public static int setBits(int n) {
        int count  = 0;
        while (n > 0) {
            if (n%2 == 1) // OR ((n & 1) == 1)
                count++;
            n >>= 1; // OR n /= 2
        }
        return count;
    }

    // Time: O(log2(n)) but avg case O(set bits), Space: O(1)
    public static int setBitsOpt(int n) {
        int count = 0;
        while (n != 0) { // runs till each set bit gets unset
            count++;
            n = n & (n-1); // sets the least significant set bit to 0
        }
        return count;
    }
}
