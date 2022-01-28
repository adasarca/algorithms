package recap.v3;

public class SelectionSort {

    public static void main(String[] args) {
        int[] a = new int[]{3, -4, 0, 15, -2, 1, 13, 9, 8, 20, 2, 3, 7};
        SelectionSort selectionSort = new SelectionSort();
        selectionSort.sort(a);

        for (int x : a) {
            System.out.print(x + " ");
        }
    }

    public void sort(int[] a) {
        int n = a.length;

        for (int i = 0; i < n - 1; i++) {
            int min = i;

            for (int j = i + 1; j < n; j++) {
                if (a[min] > a[j])
                    min = j;
            }

            int aux = a[i];
            a[i] = a[min];
            a[min] = aux;
        }
    }
}
