package recap.v3;

public class MergeSort {

    public static void main(String[] args) {
        int[] a = new int[]{3, -4, 0, 15, -2, 1, 13, 9, 8, 20, 2, 3, 7};
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(a);

        for (int x : a) {
            System.out.print(x + " ");
        }
    }

    public void sort(int[] a) {
        sort(a, 0, a.length - 1);
    }

    private void sort(int[] a, int l, int r) {
        if (l >= r) return;

        int m = (l + r) / 2;
        sort(a, l, m);
        sort(a, m + 1, r);
        merge(a, l, m, r);
    }

    private void merge(int[] a, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int[] a1 = new int[n1];
        int[] a2 = new int[n2];

        for (int i = 0; i < n1; i++) {
            a1[i] = a[i + l];
        }

        for (int i = 0; i < n2; i++) {
            a2[i] = a[i + m + 1];
        }

        int i = 0;
        int j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (a1[i] < a2[j]) {
                a[k++] = a1[i++];
            } else {
                a[k++] = a2[j++];
            }
        }

        while (i < n1) {
            a[k++] = a1[i++];
        }

        while (j < n2) {
            a[k++] = a2[j++];
        }
    }
}
