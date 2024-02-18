package JavaDS.Stacks;

import java.util.Deque;
import java.util.LinkedList;

// Time: O(n), Space: O(k)

public class SlidingWindow {
    public static void main(String[] args) {
        int arr[] = { 12, 1, 78, 90, 57, 89, 56 };
        int K = 3;
        printMax(arr, arr.length, K);
    }

    static void printMax(int arr[], int N, int K) {
        Deque<Integer> Qi = new LinkedList<>();
        int i;
        for (i = 0; i < K; ++i) {
            // For every element, the previous
            // smaller elements are useless so
            // remove them from Qi
            while (!Qi.isEmpty()
                    && arr[i] >= arr[Qi.peekLast()])
                Qi.removeLast();
            Qi.addLast(i);
        }
        // Process rest of the elements,
        // i.e., from arr[k] to arr[n-1]
        for (; i < N; ++i) {
            // The element at the front of the
            // queue is the largest element of
            // previous window, so print it
            System.out.print(arr[Qi.peek()] + " ");
            // Remove the elements which
            // are out of this window
            while ((!Qi.isEmpty()) && Qi.peek() <= i - K)
                Qi.removeFirst();
            // Remove all elements smaller
            // than the currently
            // being added element (remove
            // useless elements)
            while ((!Qi.isEmpty())
                    && arr[i] >= arr[Qi.peekLast()])
                Qi.removeLast();
            // Add current element at the rear of Qi
            Qi.addLast(i);
        }
        // Print the maximum element of last window
        System.out.print(arr[Qi.peek()]);
    }
}
