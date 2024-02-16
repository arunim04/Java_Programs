package JavaDS.Stacks;

// Time: O(n * m), Space: O(m)

import java.util.Scanner;

import static JavaDS.Stacks.MaxAreaInHistogram.*;

public class MaxAreaInMatrix {
    public static void main (String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter # rows for 2-d array:");
        int rows = sc.nextInt();
        System.out.println("Enter # cols for 2-d array:");
        int cols = sc.nextInt();
        int al[][] = new int[rows][cols];
        for (int i = 0; i < al.length; i++) {
            System.out.println("Enter values (0 or 1) for row: " + i);
            for (int j = 0; j < al[0].length; j++) {
                System.out.println("Enter value (0 or 1) for col: " + j);
                al[i][j] = sc.nextInt();
            }
        }
        System.out.println();
        System.out.println("Max area in matrix: " + maxAreaInMatrix(al));
    }

    public static int maxAreaInMatrix(int[][] arr) {
        int maxAreaMatrix = 0;
        int heights[] = new int[arr[0].length];
        for (int i = 0; i < arr.length; i++) {          // each row becomes a row in histogram
            for (int j = 0; j < arr[0].length; j++) {   // each col becomes the height of a histogram block (with the current row as the base)
                if (arr[i][j] == 0)
                    heights[j] = 0;                     // if 0 is encountered, make the height at that col = 0
                else heights[j] += 1;                   // else increase the height at that col by 1
            }
            maxAreaMatrix = Math.max(maxAreaMatrix, maxArea(heights, previousSmaller(heights), nextSmaller(heights)));
        }
        return maxAreaMatrix;
    }
}
