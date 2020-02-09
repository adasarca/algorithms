package math;

public class PreviousPermutation {

    public int[] previous(int[] a) {
        int n = a.length;
        if (n < 2) return a;

        int pos = n - 2;
        while (pos > -1 && a[pos] < a[pos + 1]) {
            pos--;
        }

        if (pos > -1) {
            int max = pos + 1;
            while (a[max + 1] < a[pos]) {
                max++;
            }
            swap(a, pos, max);
        }

        reverse(a, pos + 1);
        return a;
    }

    private void swap(int[] a, int i, int j) {
        int aux = a[i];
        a[i] = a[j];
        a[j] = aux;
    }

    private void reverse(int[] a, int start) {
        int i = start, j = a.length - 1;
        while(i < j) {
            this.swap(a, i++, j--);
        }
    }
}
