public class SetMatrixZeros {

    public void setZeroesBetter(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        boolean[] row = new boolean[n];
        boolean[] col = new boolean[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public void setZeroesOptimal(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int col0 = 1;
        // int col = mat[0][..]
        // int row = mat[..][0]

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    // mark i-th row
                    mat[i][0] = 0;
                    // mark j-th col
                    if (j == 0)
                        col0 = 0;
                    else
                        mat[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (mat[i][j] != 0) {
                    if (mat[i][0] == 0 || mat[0][j] == 0) {
                        mat[i][j] = 0;
                    }
                }
            }
        }

        if (mat[0][0] == 0) { // for row
            for (int i = 0; i < m; i++) {
                mat[0][i] = 0;
            }
        }

        if (col0 == 0) { // for col
            for (int j = 0; j < n; j++) {
                mat[j][0] = 0;
            }
        }
    }
}
