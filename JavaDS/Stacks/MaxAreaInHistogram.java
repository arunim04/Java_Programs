package JavaDS.Stacks;

// Time: O(n), Space: O(n)

import java.util.Scanner;
import java.util.Stack;

public class MaxAreaInHistogram {
    public static void main (String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter length of array of histogram blocks:");
        int[] arr = new int[sc.nextInt()];
        int i = 0;
        while (i < arr.length) {
            System.out.println("Enter height: ");
            arr[i] = sc.nextInt();
            i++;
        }
        System.out.print("Inputted array: ");
        for (int val: arr) System.out.print(val + " ");
        System.out.println();
        System.out.println("Max area: " + maxArea(arr, previousSmaller(arr), nextSmaller(arr)));
    }

    public static int[] previousSmaller(int[] arr) {
        int prevSmallerIndex[] = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < arr.length; i++) {
            while (stack.peek() != -1 && arr[stack.peek()] >= arr[i])
                stack.pop();
            prevSmallerIndex[i] = stack.peek();
            stack.push(i);
        }
        return prevSmallerIndex;
    }

    public static int[] nextSmaller(int[] arr) {
        int nextSmallerIndex[] = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(arr.length);
        for (int i = arr.length-1; i > 0; i--) {
            while (stack.peek() != arr.length && arr[stack.peek()] >= arr[i])
                stack.pop();
            nextSmallerIndex[i] = stack.peek();
            stack.push(i);
        }
        return nextSmallerIndex;
    }

    public static int maxArea(int[] arr, int[] prevSmallerIndex, int[] nextSmallerIndex) {
        int maxArea = 0;
        for (int i = 0; i < arr.length; i++) {
            maxArea = Math.max(maxArea, arr[i] * (nextSmallerIndex[i] - prevSmallerIndex[i] -1));
        }
        return maxArea;
    }
}
