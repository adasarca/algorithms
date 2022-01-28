package recap.v3;

public class LCM {

    public static void main(String[] args) {
        LCM lcm = new LCM();
        System.out.println(lcm.lcm(4, 6));
    }

    public int lcm(int a, int b) {
        if (b == 0) return 0;

        int x = a;
        int y = b;
        int aux;
        while (y != 0) {
            aux = y;
            y = x % y;
            x = aux;
        }

        return (a / x) * b;
    }
}
