package recap.v3;

public class AllPermutations {

    private int[][] solution;
    private int index;

    public static void main(String[] args) {
        AllPermutations allPermutations = new AllPermutations();
        int[][] permutations = allPermutations.generate(4);

        for(int[] p : permutations) {
            for (int x : p)
                System.out.print(x + " ");
            System.out.println();
        }
    }

    public int[][] generate(int n) {
        int fact = 1;
        for (int i = 2; i <= n; i++)
            fact *= i;

        solution = new int[fact][n];
        index = 0;

        int[] p = new int[n];
        for (int i = 0; i < n; i++)
            p[i] = i + 1;

        this.generate(p, n);
        return solution;
    }

    private void generate(int[] p, int k) {
        if (k == 1) {
            for (int i = 0; i < p.length; i++)
                solution[index][i] = p[i];
            index++;
            return;
        }

        this.generate(p, k - 1);
        for (int i = 0; i < k - 1; i++) {
            if (k % 2 == 0)
                this.swap(p, i, k - 1);
            else
                this.swap(p, 0, k - 1);
            this.generate(p, k - 1);
        }
    }

    private void swap(int[] p, int x, int y) {
        int aux = p[x];
        p[x] = p[y];
        p[y] = aux;
    }
}
