package recap.v3;

public class QuickSort {

    public static void main(String[] args) {
        int[] a = new int[]{3, -4, 0, 15, -2, 1, 13, 9, 8, 20, 2, 3, 7};
        QuickSort quickSort = new QuickSort();
        quickSort.sort(a);

        for (int x : a) {
            System.out.print(x + " ");
        }
    }

    public void sort(int[] a) {
        sort(a, 0, a.length - 1);
    }

    private void sort(int[] a, int l, int r) {
        if (l >= r) return;

        int p = partition(a, l, r);
        sort(a, l, p - 1);
        sort(a, p + 1, r);
    }

    private int partition(int[] a, int l, int r) {
        int pivot = a[r];
        int k = l;

        for (int i = l; i < r; i++) {
            if (a[i] <= pivot) {
                int aux = a[k];
                a[k] = a[i];
                a[i] = aux;
                k++;
            }
        }

        a[r] = a[k];
        a[k] = pivot;
        return k;
    }
}
