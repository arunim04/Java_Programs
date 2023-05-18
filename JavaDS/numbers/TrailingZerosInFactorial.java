package JavaDS.numbers;
import java.util.Scanner;

// Trailing zeros in the factorial of a number
// Time: O(log5(n)), Space: O(1)

public class TrailingZerosInFactorial {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number: ");
        try {
            System.out.println(trailingZeroes(sc.nextInt()));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static int trailingZeroes(int n) {
        int count = 0;
        while (n != 0) {
            n /= 5;
            count += n;  // count no. of factors of 5 (no need to find for 2)
        }
        return count;
    }
}
