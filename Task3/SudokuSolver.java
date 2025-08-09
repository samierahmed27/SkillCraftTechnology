public class SudokuSolver {

    // Method to solve the Sudoku using Backtracking
    public static boolean solveSudoku(int[][] board, int row, int col) {
        if (row == 9) {
            return true; // Puzzle solved
        }

        // Move to the next row
        if (col == 9) {
            return solveSudoku(board, row + 1, 0);
        }

        // Skip already filled cells
        if (board[row][col] != 0) {
            return solveSudoku(board, row, col + 1);
        }

        // Try placing numbers 1 to 9
        for (int num = 1; num <= 9; num++) {
            if (isSafe(board, row, col, num)) {
                board[row][col] = num; // Place number

                if (solveSudoku(board, row, col + 1)) {
                    return true;
                }

                board[row][col] = 0; // Backtrack
            }
        }
        return false; // Trigger backtracking
    }

    // Check if placing num at board[row][col] is safe
    public static boolean isSafe(int[][] board, int row, int col, int num) {
        // Check row
        for (int x = 0; x < 9; x++) {
            if (board[row][x] == num) {
                return false;
            }
        }

        // Check column
        for (int x = 0; x < 9; x++) {
            if (board[x][col] == num) {
                return false;
            }
        }

        // Check 3x3 subgrid
        int startRow = row - row % 3;
        int startCol = col - col % 3;

        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == num) {
                    return false;
                }
            }
        }
        return true;
    }

    // Print the Sudoku board
    public static void printBoard(int[][] board) {
        for (int r = 0; r < 9; r++) {
            for (int d = 0; d < 9; d++) {
                System.out.print(board[r][d] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] board = {
            {5, 3, 0, 0, 7, 0, 0, 0, 0},
            {6, 0, 0, 1, 9, 5, 0, 0, 0},
            {0, 9, 8, 0, 0, 0, 0, 6, 0},
            {8, 0, 0, 0, 6, 0, 0, 0, 3},
            {4, 0, 0, 8, 0, 3, 0, 0, 1},
            {7, 0, 0, 0, 2, 0, 0, 0, 6},
            {0, 6, 0, 0, 0, 0, 2, 8, 0},
            {0, 0, 0, 4, 1, 9, 0, 0, 5},
            {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        if (solveSudoku(board, 0, 0)) {
            System.out.println("Solved Sudoku:");
            printBoard(board);
        } else {
            System.out.println("No solution exists for this Sudoku.");
        }
    }
}