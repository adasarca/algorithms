/**
 * Created by Ada.Sarca
 * Date: 8/23/2018
 */
package sort;

import util.PrintUtil;

public class QuickSort {

    public void sort(int[] a) {
        if (a != null) {
            this.sort(a, 0, a.length - 1);
        }
    }

    private void sort(int[] a, int l, int r) {
        if (l >= r) {
            return;
        }

        int pi = partition(a, l, r);
        sort(a, l, pi - 1);
        sort(a, pi + 1, r);
    }

    private int partition(int[] a, int l, int r) {
        int pivot = a[r];
        int k = l;

        for (int j = l; j < r; j++) {
            if (a[j] <= pivot) {
                int aux = a[k];
                a[k] = a[j];
                a[j] = aux;
                k++;
            }
        }

        a[r] = a[k];
        a[k] = pivot;
        return k;
    }

    public static void main(String[] args) {
        int[] a = {-6, 8, 10, 155, 264, -85, -83, 21, 19, -25, -6};

        QuickSort quickSort = new QuickSort();
        quickSort.sort(a);

        PrintUtil.print(a);
    }
}
