package math;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class PreviousPermutationTest {

    private PreviousPermutation previousPermutation;

    @BeforeMethod
    public void setup() {
        this.previousPermutation = new PreviousPermutation();
    }

    @Test
    public void testPrevious0() throws Exception {
        //setup
        int[] a = new int[]{ 6, 2, 3, 0, 1, 4, 5 };
        int[] expected = new int[]{ 6, 2, 1, 5, 4, 3, 0 };

        //test
        int[] b = this.previousPermutation.previous(a);

        //verify
        assertEquals(b, expected);
    }

}