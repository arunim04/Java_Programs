package JavaDS.twodarray;

// Time: O(n^2), Space: O(n+n) if we consider stack space for recursive calls, else O(n)

public class NQueenProblem {
    final int N = 4;
    void printSolution(int board[][])
    {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(" " + board[i][j]
                        + " ");
            System.out.println();
        }
    }
    boolean isSafe(int board[][], int row, int col)
    {
        int i, j;
        /* Check this row on left side */
        for (i = 0; i < col; i++)
            if (board[row][i] == 1)
                return false;
        /* Check upper diagonal on left side */
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;
        /* Check lower diagonal on left side */
        for (i = row, j = col; j >= 0 && i < N; i++, j--)
            if (board[i][j] == 1)
                return false;
        return true;
    }

    boolean solveNQUtil(int board[][], int col)
    {
        if (col >= N)
            return true;
		/* Consider this column and try placing
		this queen in all rows one by one */
        for (int i = 0; i < N; i++) {
			/* Check if the queen can be placed on
			board[i][col] */
            if (isSafe(board, i, col)) {
                /* Place this queen in board[i][col] */
                board[i][col] = 1;
                /* recur to place rest of the queens */
                if (solveNQUtil(board, col + 1) == true)
                    return true;
                board[i][col] = 0; // BACKTRACK
            }
        }
        return false;
    }
    boolean solveNQ()
    {
        int board[][] = { { 0, 0, 0, 0 },
                { 0, 0, 0, 0 },
                { 0, 0, 0, 0 },
                { 0, 0, 0, 0 } };

        if (solveNQUtil(board, 0) == false) {
            System.out.print("Solution does not exist");
            return false;
        }
        printSolution(board);
        return true;
    }
    public static void main(String args[])
    {
        NQueenProblem Queen = new NQueenProblem();
        Queen.solveNQ();
    }
}

