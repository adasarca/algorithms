/*
 * Created by AdelaSarca
 * Date: 3/6/2020
 */
package math;

import java.util.List;

public class AllPermutations {

    public void generate(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = i + 1;
        }
        this.generate(n, a);
    }

    private void generate(int k, int[] a) {
        if (k == 1) {
            this.print(a);
            return;
        }

        this.generate(k - 1, a);
        for (int i = 0; i < k - 1; i++) {
            if (k % 2 == 0) {
                this.swap(a, i, k - 1);
            } else {
                this.swap(a, 0, k - 1); // to not repeat permutations
            }
            this.generate(k - 1, a);
        }
    }

    private void swap(int[] a, int x, int y) {
        int aux = a[x];
        a[x] = a[y];
        a[y] = aux;
    }

    private void print(int[] a) {
        for (int x : a) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}
