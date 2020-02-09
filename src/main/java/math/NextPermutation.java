package math;

public class NextPermutation {

    public int[] next(int[] a) {
        int n = a.length;
        if (n < 2) return a;

        //find first element which is not in descending order (from right to left)
        int pos = n - 2;
        while (pos > -1 && a[pos] >= a[pos + 1]) {
            pos--;
        }

        if (pos > -1) {
            //swap with min greater number from right sub-array
            int min = n - 1;
            while(a[min] < a[pos]) {
                min--;
            }
            this.swap(a, pos, min);
        }

        //reverse right sub-array
        this.reverse(a, pos + 1);
        return a;
    }

    private void swap(int[] a, int x, int y) {
        int aux = a[x];
        a[x] = a[y];
        a[y] = aux;
    }

    private void reverse(int[] a, int start) {
        int i = start, j = a.length - 1;
        while (i < j) {
            this.swap(a, i++, j--);
        }
    }
}
