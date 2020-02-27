/*
 * Created by AdelaSarca
 * Date: 2/27/2020
 */
package recap.v2.sorting;

public class QuickSort {

    public void sort(int[] a) {
        this.sort(a, 0, a.length - 1);
    }

    private void sort(int[] a, int l, int r) {
        if (l >= r) return;

        int p = this.partition(a, l, r);
        this.sort(a, l, p - 1);
        this.sort(a, p + 1, r);
    }

    private int partition(int[] a, int l, int r) {
        int pivot = a[r];
        int k = l;
        for (int i = l; i <= r; i++) {
            if (a[i] <= pivot) {
                int aux = a[k];
                a[k] = a[i];
                a[i] = aux;
                k++;
            }
        }
        return k - 1;
    }
}
