package JavaDS.Stacks;

// Time: O(n), Space: O(n)

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class isParenthesisMatching {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter string: ");
        String str = sc.nextLine();
        System.out.println();
        System.out.println(stringParse(str));
    }

    public static boolean stringParse(String str) {
        Map<Character,Character> map = new HashMap<>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (map.containsKey(str.charAt(i))) {
                char top = stack.isEmpty() ? '#' : stack.pop();
                if (top != map.get(str.charAt(i)))
                    return false;
            } else
                stack.push(str.charAt(i));
        }
        return stack.isEmpty();
    }
}
