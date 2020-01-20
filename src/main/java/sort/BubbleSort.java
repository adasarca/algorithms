/**
 * Created by Ada.Sarca
 * Date: 8/23/2018
 */
package sort;

import util.PrintUtil;

public class BubbleSort {

    public void sort(int[] a) {
        if (null == a) {
            return;
        }

        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (a[j] > a[j+1]) {
                    int aux = a[j];
                    a[j] = a[j+1];
                    a[j+1] = aux;
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {-6, 8, 10, 155, 264, -85, -83, 21, 19, -25, -6};

        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(a);

        PrintUtil.print(a);
    }
}
