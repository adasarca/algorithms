package interview.ms2020.task1;

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
        int[] A = new int[] {1,2,3,3};
        int[] B = new int[] {2,3,1,4};

        //test
        int rank = this.solution.solution(A, B, 4);

        //verify
        assertEquals(rank, 4);
    }

    @Test
    public void testSolution2() throws Exception {
        //setup
        int[] A = new int[] {1,2,4,5};
        int[] B = new int[] {2,3,5,6};

        //test
        int rank = this.solution.solution(A, B, 6);

        //verify
        assertEquals(rank, 2);
    }

}