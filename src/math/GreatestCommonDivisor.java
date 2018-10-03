/**
 * Created by Ada.Sarca
 * Date: 10/3/2018
 */
package math;

public class GreatestCommonDivisor {

    public int euclid(int a, int b) {
        while (b != 0) {
            int aux = b;
            b = a % b;
            a = aux;
        }
        return a;
    }

    public static void main(String[] args) {
        GreatestCommonDivisor gcd = new GreatestCommonDivisor();
        int a = 24;
        int b = 18;
        System.out.println(String.format("GCD for %d and %d is %d", a, b, gcd.euclid(a, b)));
    }
}
