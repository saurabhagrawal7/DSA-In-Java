public class SudokuSolver {
    // 0, 1, 2 - row / 3 = 0
    // 3, 4, 5 - row / 3 = 1
    // 6, 7, 8 - row / 3 = 2

    private boolean isValid(int row, int col, char[][] board, char c) {
        for (int i = 0; i < 9; i++) {
            // check row
            if (board[row][i] == c)
                return false;
            // check col
            if (board[i][col] == c)
                return false;
        }

        // 3x3 grid
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == c) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean helper(char[][] board) {

        // iterate over the entire board
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                // check if current cell is empty or filled
                if (board[i][j] == '.') {
                    // try putting 1-9 in the empty cell i.e. board[i][j]
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(i, j, board, c)) {
                            board[i][j] = c;
                            // if solution found
                            // return true
                            // no need to backtrack
                            if (helper(board))
                                return true;
                            // backtrack
                            board[i][j] = '.';
                        }
                    }
                    // can't place any of the 9 digits at i, j
                    return false;
                }
            }
        }
        // I reach here when there are not dots, that means all the entire thing is
        // filled now & it is correct
        return true;

    }

    public void solveSudoku(char[][] board) {
        helper(board);
    }
}

// TC
// No of empty spaces to be filled in the board = E
// 9 (for isvalid function) * 9 power E - for each empty cell we have 9 ways to
// fill it
// SC - O(E)