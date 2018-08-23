/**
 * Created by Ada.Sarca
 * Date: 8/8/2018
 */
package sort;

import util.PrintUtil;

public class SelectionSort {

    public void sort(int[] a) {
        if (null == a) {
            return;
        }

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

    public static void main(String[] args) {
        int[] a = {-6, 8, 10, 155, 264, -85, -83, 21, 19, -25, -6};

        SelectionSort selectionSort = new SelectionSort();
        selectionSort.sort(a);

        PrintUtil.print(a);
    }
}
