/**
 * Created by Ada.Sarca
 * Date: 9/5/2018
 */
package tree.representation;

public class ParentArray {
    public static void main(String[] args) {
        int[] parent = new int[] {-1, 0, 0, 1, 1, 1, 2, 3, 4, 4};

        for (int i = 0; i < 10; i++) {
            if (parent[i] >= 0) {
                System.out.println("Parent of " + i + " is " + parent[i]);
            } else {
                System.out.println(i + " is root");
            }
        }
    }
}
