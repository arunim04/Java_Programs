package JavaDS.onedarray;
import java.util.Scanner;
// Find subsets/subsequences of a string
// Time: O(2^n), Space: O(n) if we consider stack space for recursive calls
public class Powersets {
    public static void main (String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter string: ");
        String str = sc.nextLine();
        System.out.println("Subsets of " + str + ": ");
        findSubsets("",0,str);
    }

    public static void findSubsets(String tmp, int i, String str) {
        if (i == str.length()) {
            System.out.println(tmp);
            return;
        }
        findSubsets(tmp+str.charAt(i),i+1,str); // pick a character
        findSubsets(tmp+"",i+1,str);            // don't pick a character
    }
}
