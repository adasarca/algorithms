package recap.v3.extra;

public class MatrixRotation {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };

        MatrixRotation matrixRotation = new MatrixRotation();
        matrixRotation.rotate(matrix);
        print(matrix);
        System.out.println();

        matrix = new int[][]{
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };
        matrixRotation.rotate(matrix);
        print(matrix);
    }

    private static void print(int[][] matrix) {
        for(int[] line : matrix) {
            for (int x : line)
                System.out.print(x + " ");
            System.out.println();
        }
    }

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - i - 1; j++) {
                int aux = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = aux;
            }
        }
    }
}
