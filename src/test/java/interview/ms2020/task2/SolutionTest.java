package interview.ms2020.task2;

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
    public void testSolution1() throws Exception {
        //setup
        int[] a = new int[]{51, 71, 17, 42};

        //test
        int sum = this.solution.solution(a);

        //verify
        assertEquals(sum, 93);
    }

    @Test
    public void testSolution2() throws Exception {
        //setup
        int[] a = new int[]{42, 33, 60};

        //test
        int sum = this.solution.solution(a);

        //verify
        assertEquals(sum, 102);
    }

    @Test
    public void testSolution3() throws Exception {
        //setup
        int[] a = new int[]{51, 32, 43};

        //test
        int sum = this.solution.solution(a);

        //verify
        assertEquals(sum, -1);
    }

}