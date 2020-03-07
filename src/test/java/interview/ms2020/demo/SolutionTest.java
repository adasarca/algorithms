package interview.ms2020.demo;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SolutionTest {

    private Solution solution;

    @BeforeMethod
    public void setup() {
        this.solution = new Solution();
    }

    @Test
    public void testSolution0() throws Exception {
        //setup
        int[] a = new int[] {1, 3, 6, 4, 1, 2};

        //test
        int k = solution.solution(a);

        //verify
        assertEquals(k, 5);
    }

    @Test
    public void testSolution1() throws Exception {
        //setup
        int[] a = new int[] {-1};

        //test
        int k = solution.solution(a);

        //verify
        assertEquals(k, 1);
    }

}