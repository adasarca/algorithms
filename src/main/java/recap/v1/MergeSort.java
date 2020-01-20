package recap.v1;

import util.PrintUtil;

public class MergeSort {

    public void sort(int[] a) {
        this.sort(a, 0, a.length - 1);
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

        //copy arrays
        int[] a1 = new int[n1];
        int[] a2 = new int[n2];
        for (int i = 0; i < n1; i++) {
            a1[i] = a[l + i];
        }
        for (int j = 0; j < n2; j++) {
            a2[j] = a[m + j + 1];
        }

        //merge
        int i = 0, j = 0, k = l;
        while(i < n1 && j < n2) {
            if (a1[i] < a2[j]) {
                a[k] = a1[i++];
            } else {
                a[k] = a2[j++];
            }
            k++;
        }
        while(i < n1) {
            a[k++] = a1[i++];
        }
        while(j < n2) {
            a[k++] = a2[j++];
        }
    }

    public static void main(String[] args) {
        int[] a = new int[] {7, -4, 10, 3, 15, 17, -4, -13, 9, 23, 4};
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(a);
        PrintUtil.print(a);
    }
}
