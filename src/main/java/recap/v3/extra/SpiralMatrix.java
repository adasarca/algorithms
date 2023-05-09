package recap.v3.extra;

import java.util.*;

public class SpiralMatrix {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12}
        };
        SpiralMatrix spiralMatrix = new SpiralMatrix();
        List<Integer> output = spiralMatrix.spiralOrder(matrix);
        print(matrix);
    }

    private static void print(int[][] matrix) {
        for(int[] line : matrix) {
            for (int x : line)
                System.out.print(x + " ");
            System.out.println();
        }
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int i0 = 0;
        int j0 = 0;

        int[] di = new int[]{0, 1, 0, -1};
        int[] dj = new int[]{1, 0, -1, 0};

        int i = 0;
        int j = 0;
        int d = 0;
        List<Integer> output = new LinkedList<>();
        while (i >= i0 && i < n && j >= j0 && j < m) {
            output.add(matrix[i][j]);
            if (d == 0 && j == m - 1) {
                d++;
                i0++;
            }

            if (d == 1 && i == n - 1) {
                d++;
                m--;
            }

            if (d == 2 && j == j0) {
                d++;
                n--;
            }

            if (d == 3 && i == i0) {
                d = 0;
                j0++;
            }

            i += di[d];
            j += dj[d];
        }

        return output;
    }
}
