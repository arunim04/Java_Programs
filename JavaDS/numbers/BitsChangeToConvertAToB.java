package JavaDS.numbers;
import java.util.*;

// Find number of bits needed to be changed to convert number A to number B
// Time: O(log2(n)) but avg case O(set bits), Space: O(1)

public class BitsChangeToConvertAToB {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter A: ");
        int a = sc.nextInt();
        System.out.println("Enter B: ");
        int b = sc.nextInt();
        System.out.println(bitsChangeToConvertAToB(a,b));
    }

    public static int bitsChangeToConvertAToB(int a, int b) {
        return BitOps.setBitsOpt(a ^ b); // setBitsOpt() is defined in previous question
    }
}
