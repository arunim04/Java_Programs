package JavaDS.numbers;
import java.util.Scanner;

// Find GCD of an array of numbers (optimised method)
// Time: O(n*log(n)), Space: O(1)

public class GCDOfArray {
    public static void main (String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
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

            System.out.println("GCD of array: " + gcdOfArray(al));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static int gcdOfArray(int al[]) {
        int result = al[0];
        for (int val: al) {
            result = gcd.div(result, val); // using gcd() function of previous program
            if (result == 1)
                return 1;
        }
        return result;
    }
}
