package recap.v3;

public class PreviousPermutation {

    public static void main(String[] args) {
        int[] a = new int[]{6, 2, 3, 0, 1, 4, 5};
        PreviousPermutation previousPermutation = new PreviousPermutation();
        previousPermutation.previous(a);
        for(int x : a)
            System.out.print(x + " ");
    }

    public void previous(int[] p) {
        int n = p.length;
        if (n < 2)
            return;

        int pos = n - 2;
        while(pos > -1 && p[pos] <= p[pos + 1])
            pos--;

        if (pos > -1) {
            int max = n - 1;
            while (p[max] >= p[pos])
                max--;
            this.swap(p, pos, max);
        }

        int l = pos + 1;
        int r = n - 1;
        while(l < r)
            this.swap(p, l++, r--);
    }

    private void swap(int[] p, int x, int y) {
        int aux = p[x];
        p[x] = p[y];
        p[y] = aux;
    }
}
