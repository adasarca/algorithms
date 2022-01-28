package recap.v3;

public class NextPermutation {

    public static void main(String[] args) {
        int[] a = new int[]{7,6,5,4,3,3,2,1};
        NextPermutation nextPermutation = new NextPermutation();
        nextPermutation.next(a);
        for(int x : a)
            System.out.print(x + " ");
    }

    public void next(int[] a) {
        int n = a.length;

        int x = n - 2;
        while (x > -1 && a[x] >= a[x + 1])
            x--;

        if (x > -1) {
            int y = n - 1;
            while (a[y] <= a[x])
                y--;
            swap(a, x, y);
        }

        int l = x + 1;
        int r = n - 1;
        while (l < r)
            swap(a, l++, r--);
    }

    private void swap(int[] a, int x, int y) {
        int aux = a[x];
        a[x] = a[y];
        a[y] = aux;
    }
}
