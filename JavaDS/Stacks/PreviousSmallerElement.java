package JavaDS.Stacks;

// Time: O(n), Space: O(n)

import java.util.Scanner;
import java.util.Stack;

public class PreviousSmallerElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter length of array:");
        int[] arr = new int[sc.nextInt()];
        int i = 0;
        while (i < arr.length) {
            System.out.println("Enter number: ");
            arr[i] = sc.nextInt();
            i++;
        }
        System.out.print("Inputted array: ");
        for (int val: arr) System.out.print(val + " ");
        System.out.println();
        previousSmaller(arr);
    }

    public static void previousSmaller(int[] arr) {     // similarly, can do for previous greater element // similarly, can do for next smaller element (traverse in reverse)
        Stack<Integer> stack = new Stack<>();
        stack.push(Integer.MIN_VALUE);                  // use Integer.MAX_VALUE (or anything else suitable) for previous greater element
        for (int val : arr) {
            while (stack.peek() > val) {                // for previous greater element, replace with: (stack.peek() < val) // instead of using Integer.MIN_VALUE, can add another condition: "!stack.isEmpty()"
                stack.pop();
            }
            System.out.print(stack.peek() + " ");
            stack.push(val);
        }
    }
}
