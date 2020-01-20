package recap.v2;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/*
 * Created by AdelaSarca
 * Date: 1/20/2020
 */
public class LongestIncreasingSubsequenceTest {

    private LongestIncreasingSubsequence longestIncreasingSubsequence;

    @BeforeMethod
    public void setup() {
        this.longestIncreasingSubsequence = new LongestIncreasingSubsequence();
    }

    @Test
    public void testSequence() {
        //setup
        int[] a = new int[] {10, 22, 9, 33, 21, 50, 41, 60, 80};
        int[] expected = new int[] {10, 22, 33, 50, 60, 80};

        //test
        int[] res = this.longestIncreasingSubsequence.sequence(a);

        //verify
        assertEquals(res, expected);
    }
}