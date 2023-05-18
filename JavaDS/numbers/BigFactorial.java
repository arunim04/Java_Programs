package JavaDS.numbers;
import java.util.*;
import java.math.BigInteger;
// Find factorial for a number with bigger factorial
// Time: O(n), Space: O(n) if we consider stack space for recursive calls

public class BigFactorial {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number: ");
        try {
            System.out.println(bigFactorial(sc.nextInt()));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static BigInteger bigFactorial(int n) {
        BigInteger bg = BigInteger.valueOf(n);
        return n == 0 ? new BigInteger("1") : bg.multiply(bigFactorial(n-1));
    }
}
