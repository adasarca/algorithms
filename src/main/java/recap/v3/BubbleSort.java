package recap.v3;

public class BubbleSort {

    public static void main(String[] args) {
        int[] a = new int[]{3, -4, 0, 15, -2, 1, 13, 9, 8, 20, 2, 3, 7};
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(a);

        for (int x : a) {
            System.out.print(x + " ");
        }
    }

    public void sort(int[] a) {
        int n = a.length;
        boolean swapped = true;

        while (swapped) {
            swapped = false;
            for (int i = 0; i < n - 1; i++) {
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
