package JavaDS.Stacks;

// Time: O(n), Space: O(n)

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class InfixToPostfix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter an infix expression: ");
        String str = sc.nextLine();
        System.out.println("Postfix expression: " + infixToPostfix(str));
    }

    static int getPriority(char c)
    {
        switch (c) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    public static String infixToPostfix(String infixStr) {
        String postfixStr = "";
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < infixStr.length(); i++) {
            char c = infixStr.charAt(i);
            if (Character.isLetterOrDigit(c))                               // if c is an operand, add it to postfixStr
                postfixStr += c;
            else if (c == '(')                                              // if c is '(', add it to postfixStr
                stack.push(c);
            else if (c == ')') {                                            // if c is ')', pop from the stack & add to postfixStr until '(' is encountered
                while (!stack.isEmpty() && stack.peek() != '(')
                    postfixStr += stack.pop();
                stack.pop();                                                // pop '('
            }
            else {                                                          // if c is an operator, maintain operators in stack from low priority operator (at bottom) to higher priority operator (at top)
                while(!stack.isEmpty() &&
                        getPriority(stack.peek()) >= getPriority(c)) {
                    postfixStr += stack.pop();                              // pop if incoming character has lesser priority than the one at top of the stack
                }
                stack.push(c);
            }
        }

        while(!stack.isEmpty()) {                                           // pop remaining elements & add them to postfixStr
            postfixStr += stack.pop();
        }

        return postfixStr;
    }
}
