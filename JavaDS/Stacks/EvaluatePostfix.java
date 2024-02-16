package JavaDS.Stacks;

// Time: O(n), Space: O(n)

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class EvaluatePostfix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a postfix expression: ");
        String str = sc.nextLine();
        System.out.println("Answer: " + evaluatePostfix(str));
    }

    public static int evaluatePostfix(String postfixStr) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < postfixStr.length(); i++) {
            char c = postfixStr.charAt(i);
            if (Character.isDigit(c))       // if c is an operand, push it to stack
                stack.push(c - '0');     // subtract ASCII value of c from ASCII value of 0 to get integer value of c  // other way: Integer.parseInt(String.valueOf(ch))
            else {                          // if c is an operator, pop elements from the stack and start evaluating on this operator
                int val1 = stack.pop();
                int val2 = stack.pop();
                switch (c) {
                    case '/':
                        stack.push(val2 / val1);
                        break;
                    case '*':
                        stack.push(val2 * val1);
                        break;
                    case '+':
                        stack.push(val2 + val1);
                        break;
                    case '-':
                        stack.push(val2 - val1);
                        break;
                    case '^':
                        stack.push(val2 ^ val1);
                        break;
                }
            }
        }
        return stack.pop();
    }
}
