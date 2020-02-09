package math;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class PermutationSequenceTest {

    private PermutationSequence permutationSequence;

    @BeforeMethod
    public void setup() {
        this.permutationSequence = new PermutationSequence();
    }

    @Test
    public void testCalculate0() throws Exception {
        //setup
        Integer[] expected = new Integer[]{ 2, 3, 1, 4 };

        //test
        Integer[] permutation = this.permutationSequence.calculate(4, 9);

        //verify
        assertEquals(permutation, expected);
    }

    @Test
    public void testCalculate1() throws Exception {
        //test
        Integer[] permutation = this.permutationSequence.calculate(4, 30);

        //verify
        assertNull(permutation);
    }

}