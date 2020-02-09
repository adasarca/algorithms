package math;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class NextPermutationTest {

    private NextPermutation nextPermutation;

    @BeforeMethod
    public void setup() {
        this.nextPermutation = new NextPermutation();
    }

    @Test
    public void testNext0() throws Exception {
        //setup
        int[] permutation = new int[]{ 6, 2, 1, 5, 3, 4, 0 };
        int[] expected = new int[]{ 6, 2, 1, 5, 4, 0, 3 };

        //test
        int[] next = this.nextPermutation.next(permutation);

        //verify
        assertEquals(next, expected);
    }

    @Test
    public void testNext1() throws Exception {
        //setup
        int[] permutation = new int[]{ 6, 2, 1, 5, 4, 3, 0 };
        int[] expected = new int[]{ 6, 2, 3, 0, 1, 4, 5 };

        //test
        int[] next = this.nextPermutation.next(permutation);

        //verify
        assertEquals(next, expected);
    }

    @Test
    public void testNext2() throws Exception {
        //setup
        int[] permutation = new int[]{ 6 };
        int[] expected = new int[]{ 6 };

        //test
        int[] next = this.nextPermutation.next(permutation);

        //verify
        assertEquals(next, expected);
    }

}