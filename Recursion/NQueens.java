import java.util.*;

public class NQueens {
    private boolean isValid(int row, int col, List<String> board, int n) {
        // check horizontally
        for (int c = col; c >= 0; c--)
            if (board.get(row).charAt(c) == 'Q')
                return false;

        // check diagonally - left top
        for (int r = row, c = col; r >= 0 && c >= 0; r--, c--)
            if (board.get(r).charAt(c) == 'Q')
                return false;

        // check diagonally - left bottom
        for (int r = row, c = col; r < n && c >= 0; r++, c--)
            if (board.get(r).charAt(c) == 'Q')
                return false;

        return true;
    }

    private void helper(int col, List<List<String>> res, List<String> board, int n) {
        if (col == n) {
            res.add(new ArrayList<String>(board));
            return;
        }

        // for every col i am going row wise
        for (int row = 0; row < n; row++) {
            if (isValid(row, col, board, n)) {
                char[] charBoard = board.get(row).toCharArray();
                charBoard[col] = 'Q';
                board.set(row, new String(charBoard));
                helper(col + 1, res, board, n);
                charBoard[col] = '.';
                board.set(row, new String(charBoard));
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        List<String> board = new ArrayList<>();
        String s = ".".repeat(n);
        for (int i = 0; i < n; i++)
            board.add(s);
        helper(0, res, board, n);
        return res;
    }
}

// considering col wise
// for every n col I am calling & inside every col there is a for loop for every
// n rows
// In 1st col I have n places to fill, in 2nd n-1, in 3rd n-2
// n x n-1 x n-2 ...... 1 => n!
// for all n! cases we are running 3 loops each of O(n)
// hence for all the n! cases we are doing O(n) validity
// hence TC - O(n x n!)

// SC - O(n)