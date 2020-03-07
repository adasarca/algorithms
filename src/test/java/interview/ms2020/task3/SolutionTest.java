package interview.ms2020.task3;

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
        String riddle = "abc?ac?";

        String s = this.solution.solution(riddle);

        this.assertCorrectness(s);
    }

    @Test
    public void testSolution2() throws Exception {
        String riddle = "rd?e?wg??";

        String s = this.solution.solution(riddle);

        this.assertCorrectness(s);
    }

    @Test
    public void testSolution3() throws Exception {
        String riddle = "????????";

        String s = this.solution.solution(riddle);

        this.assertCorrectness(s);
    }

    @Test
    public void testSolution4() throws Exception {
        String riddle = "??????????????ababababa?????aba";

        String s = this.solution.solution(riddle);

        this.assertCorrectness(s);
    }

    private void assertCorrectness(String s) {
        int n = s.length();
        for (int i = 0; i < n - 1; i++) {
            assertNotEquals(s.charAt(i), s.charAt(i + 1));
        }
    }

}