/*
 * Created by AdelaSarca
 * Date: 3/6/2020
 */
package math;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class AllPermutations2 {

    public void generate(int n) {
        int[] a = new int[n];
        boolean[] visited = new boolean[n + 1];

        this.generate(n, 0, a, visited);
    }

    private void generate(int n, int pos, int[] a, boolean[] visited) {
        if (pos == a.length) {
            this.print(a);
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                a[pos] = i;
                this.generate(n, pos + 1, a, visited);
                visited[i] = false;
            }
        }
    }

    private void print(int[] a) {
        for (int x : a) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}
