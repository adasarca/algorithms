package recap.v2.math;

public class NextPermutation {

    public int[] next(int[] p) {
        int n = p.length;

        //find first number before last decreasing sequence
        int x = n - 2;
        while(x > -1 && p[x] >= p[x + 1])
            x--;

        //p is already last permutation
        if (x == -1)
            return null;

        //find min number greater than x from right sub-array
        int min = n - 1;
        while(p[min] <= p[x])
            min--;
        this.swap(p, min, x);

        //reverse right sub-array
        int l = x + 1;
        int r = n - 1;
        while(l < r) {
            this.swap(p, l, r);
        }
        return p;
    }

    private void swap(int[] a, int i, int j) {
        int aux = a[i];
        a[i] = a[j];
        a[j] = aux;
    }
}
