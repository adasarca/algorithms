package util;

/**
 * Created by Ada.Sarca
 * Date: 8/8/2018
 */

public class PrintUtil {
    public static void print(int[] a) {
        if (null == a) {
            System.out.println("null");
            return;
        }

        for (int element : a) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}
