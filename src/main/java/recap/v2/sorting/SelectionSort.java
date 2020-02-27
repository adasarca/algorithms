/*
 * Created by AdelaSarca
 * Date: 2/27/2020
 */
package recap.v2.sorting;

public class SelectionSort {

    public void sort(int[] a) {
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            int min = i;

            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }

            if (min != i) {
                int aux = a[i];
                a[i] = a[min];
                a[min] = aux;
            }
        }
    }
}
