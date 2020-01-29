package graph;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

/*
 * Created by AdelaSarca
 * Date: 1/29/2020
 */
public class DirectedGraphCyclesTest {

    private DirectedGraphCycles directedGraphCycles;

    @BeforeMethod
    public void setup() {
        this.directedGraphCycles = new DirectedGraphCycles();
    }

    @Test
    public void testHasCycles0() {
        //setup
        List<Integer>[] graph = new List[6];
        graph[0] = Arrays.asList();
        graph[1] = Arrays.asList();
        graph[2] = Arrays.asList(3);
        graph[3] = Arrays.asList(1);
        graph[4] = Arrays.asList(0);
        graph[5] = Arrays.asList(2, 0);

        //test
        boolean result = this.directedGraphCycles.hasCycles(graph);

        //verify
        assertFalse(result);
    }

    @Test
    public void testHasCycles1() {
        //setup
        List<Integer>[] graph = new List[6];
        graph[0] = Arrays.asList();
        graph[1] = Arrays.asList(2);
        graph[2] = Arrays.asList(3);
        graph[3] = Arrays.asList(1);
        graph[4] = Arrays.asList(0);
        graph[5] = Arrays.asList(2, 0);

        //test
        boolean result = this.directedGraphCycles.hasCycles(graph);

        //verify
        assertTrue(result);
    }

    @Test
    public void testHasCycles2() {
        //setup
        List<Integer>[] graph = new List[10];
        graph[0] = Arrays.asList(1);
        graph[1] = Arrays.asList(2, 4, 5, 7);
        graph[2] = Arrays.asList(3, 6);
        graph[3] = Arrays.asList(8, 9);
        graph[4] = Arrays.asList();
        graph[5] = Arrays.asList(8);
        graph[6] = Arrays.asList(8, 9);
        graph[7] = Arrays.asList(8);
        graph[8] = Arrays.asList();
        graph[9] = Arrays.asList();
        List<Integer> expected = Arrays.asList(0, 1, 7, 5, 4, 2, 6, 3, 9, 8);

        //test
        boolean result = this.directedGraphCycles.hasCycles(graph);

        //verify
        assertFalse(result);
    }
}