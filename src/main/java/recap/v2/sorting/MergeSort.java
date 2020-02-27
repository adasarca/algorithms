/*
 * Created by AdelaSarca
 * Date: 2/27/2020
 */
package recap.v2.sorting;

public class MergeSort {

    public void sort(int[] a) {
        this.sort(a, 0, a.length - 1);
    }

    private void sort(int[] a, int l, int r) {
        if (l >= r) return;

        int m = (l + r) / 2;
        this.sort(a, l, m);
        this.sort(a, m + 1, r);
        this.merge(a, l, m, r);
    }

    private void merge(int[] a, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        int[] a1 = new int[n1];
        int[] a2 = new int[n2];

        for (int i = 0; i < n1; i++) {
            a1[i] = a[i + l];
        }
        for (int j = 0; j < n2; j++) {
            a2[j] = a[m + j + 1];
        }

        int i = 0, j = 0, k = l;
        while(i < n1 && j < n2) {
            if (a1[i] < a2[j]) {
                a[k++] = a1[i++];
            } else {
                a[k++] = a2[j++];
            }
        }
        while(i < n1) {
            a[k++] = a1[i++];
        }
        while(j < n2) {
            a[k++] = a2[j++];
        }
    }
}
