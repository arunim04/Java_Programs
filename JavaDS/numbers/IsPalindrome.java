package JavaDS.numbers;
import java.util.*;

public class IsPalindrome {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number: ");
        try {
            System.out.println(isPalindrome(sc.nextInt()));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static boolean isPalindrome(int num) throws Exception {
        if (num < 0 || (num%10 == 0 && num/10 != 0))
            return false;
        int rev = 0;
        while (rev < num) {
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE/10  && rev%10 > 7)) {
                throw new Exception("Value greater than max integer");
            }
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE/10  && rev%10 < -8)) {
                throw new Exception("Value less than min integer");
            }
            rev = rev * 10 + num%10;
            num /= 10;
        }
        return rev == num || rev / 10 == num;
    }
}
