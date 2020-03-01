package recap.v2.graph;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.testng.Assert.*;

public class SCCTest {

    private SCC scc;

    @BeforeMethod
    public void setup() {
        this.scc = new SCC();
    }

    @Test
    public void testComponents0() throws Exception {
        //setup
        List<Integer>[] graph = new List[5];
        graph[0] = Arrays.asList(2, 3);
        graph[1] = Arrays.asList(0);
        graph[2] = Arrays.asList(1);
        graph[3] = Arrays.asList(4);
        graph[4] = Arrays.asList();
        List<List<Integer>> expected = new LinkedList<>();
        expected.add(Arrays.asList(0, 1, 2));
        expected.add(Arrays.asList(3));
        expected.add(Arrays.asList(4));

        //test
        List<LinkedList<Integer>> components = this.scc.components(graph);

        //verify
        assertEquals(components, expected);
    }

    @Test
    public void testComponents1() throws Exception {
        //setup
        List<Integer>[] graph = new List[8];
        graph[0] = Arrays.asList(1, 6);
        graph[1] = Arrays.asList(2);
        graph[2] = Arrays.asList(3);
        graph[3] = Arrays.asList(0);
        graph[4] = Arrays.asList(5);
        graph[5] = Arrays.asList(0, 4);
        graph[6] = Arrays.asList(7);
        graph[7] = Arrays.asList();
        List<List<Integer>> expected = new LinkedList<>();
        expected.add(Arrays.asList(4, 5));
        expected.add(Arrays.asList(0, 3, 2, 1));
        expected.add(Arrays.asList(6));
        expected.add(Arrays.asList(7));

        //test
        List<LinkedList<Integer>> components = this.scc.components(graph);

        //verify
        assertEquals(components, expected);
    }

}