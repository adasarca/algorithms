/**
 * Created by Ada.Sarca
 * Date: 8/8/2018
 */
package sort;

import util.PrintUtil;

public class MergeSort {

    public void sort(int[] a) {
        if (a != null) {
            this.sort(a, 0, a.length - 1);
        }
    }

    private void sort(int[] a, int l, int r) {
        if (l >= r) {
            return;
        }

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

        for (int i = l; i <= m; i++) {
            a1[i - l] = a[i];
        }
        for (int i = m + 1; i <= r; i++) {
            a2[i - m - 1] = a[i];
        }

        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (a1[i] <= a2[j]) {
                a[k] = a1[i++];
            } else {
                a[k] = a2[j++];
            }
            k++;
        }
        while (i < n1) {
            a[k++] = a1[i++];
        }
        while(j < n2) {
            a[k++] = a2[j++];
        }
    }

    public static void main(String[] args) {
        int[] a = {-6, 8, 10, 155, 264, -85, -83, 21, 19, -25, -6};

        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(a);

        PrintUtil.print(a);
    }
}
