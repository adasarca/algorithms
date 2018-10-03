/**
 * Created by Ada.Sarca
 * Date: 10/3/2018
 */
package math;

public class LowestCommonMultiple {

    public int lcm(int a, int b) {
        if (a == 0 || b == 0) {
            return 0;
        }

        GreatestCommonDivisor greatestCommonDivisor = new GreatestCommonDivisor();
        int gcd = greatestCommonDivisor.euclid(a, b);
        return a * (b / gcd);
    }

    public static void main(String[] args) {
        int a = 15;
        int b = 12;
        LowestCommonMultiple lcm = new LowestCommonMultiple();
        System.out.println(String.format("Lowest common multiple for %d and %d is %d", a, b, lcm.lcm(a, b)));
    }
}
