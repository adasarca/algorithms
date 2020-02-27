/*
 * Created by AdelaSarca
 * Date: 2/27/2020
 */
package recap.v2.sorting;

public class BubbleSort {

    public void sort(int[] a) {
        boolean swapped = true;
        while(swapped) {
            swapped = false;
            for (int i = 0; i < a.length - 1; i++) {
                if (a[i] > a[i + 1]) {
                    int aux = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = aux;
                    swapped = true;
                }
            }
        }
    }
}
