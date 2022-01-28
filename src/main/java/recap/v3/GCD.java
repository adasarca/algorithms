package recap.v3;

public class GCD {

    public static void main(String[] args) {
        GCD gcd = new GCD();
        System.out.println(gcd.gcd(24, 64));
    }

    public int gcd(int a, int b) {
        if (b == 0) return 0;

        int aux;
        while (b != 0) {
            aux = b;
            b = a % b;
            a = aux;
        }

        return a;
    }
}
