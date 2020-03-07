package recap.v2.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PermutationGenerator {

    public List<Integer[]> generate(int n) {
        Integer[] p = new Integer[n];
        for (int i = 0; i < n; i++) {
            p[i] = i + 1;
        }

        List<Integer[]> output = new LinkedList<>();
        this.generate(n, p, output);
        return output;
    }

    private void generate(int n, Integer[] p, List<Integer[]> output) {
        if (n == 1) {
            output.add(Arrays.copyOf(p, p.length));
            return;
        }

        this.generate(n - 1, p, output);

        for (int i = 0; i < n - 1; i++) {
            if (n % 2 == 0) {
                this.swap(p, i, n - 1);
            } else {
                this.swap(p, 0, n - 1);
            }

            this.generate(n - 1, p, output);
        }
    }

    private void swap(Integer[] p, int x, int y) {
        Integer aux = p[x];
        p[x] = p[y];
        p[y] = aux;
    }
}
