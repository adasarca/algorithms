package recap.v2.graph;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.testng.Assert.*;

public class GraphTraversalTest {

    private GraphTraversal graphTraversal;

    @BeforeMethod
    public void setup() {
        this.graphTraversal = new GraphTraversal();
    }

    @Test
    public void testBfs() throws Exception {
        //setup
        List<Integer>[] graph = new List[8];
        graph[0] = Arrays.asList(1, 3, 6, 7);
        graph[1] = Arrays.asList(0, 2);
        graph[2] = Arrays.asList(1);
        graph[3] = Arrays.asList(0, 4);
        graph[4] = Arrays.asList(3);
        graph[5] = Arrays.asList();
        graph[6] = Arrays.asList(0, 1);
        graph[7] = Arrays.asList(0);
        List<Integer> expected = Arrays.asList(0, 1, 3, 6, 7, 2, 4, 5);

        //test
        List<Integer> bfs = this.graphTraversal.bfs(graph);

        //verify
        assertEquals(bfs, expected);
    }

    @Test
    public void testDfs() throws Exception {
        //setup
        List<Integer>[] graph = new List[8];
        graph[0] = Arrays.asList(1, 3, 6, 7);
        graph[1] = Arrays.asList(0, 2);
        graph[2] = Arrays.asList(1);
        graph[3] = Arrays.asList(0, 4);
        graph[4] = Arrays.asList(3);
        graph[5] = Arrays.asList();
        graph[6] = Arrays.asList(0, 1);
        graph[7] = Arrays.asList(0);
        List<Integer> expected = Arrays.asList(0, 1, 2, 3, 4, 6, 7, 5);

        //test
        List<Integer> bfs = this.graphTraversal.dfs(graph);

        //verify
        assertEquals(bfs, expected);
    }

    @Test
    public void testDfsIterative() throws Exception {
        //setup
        List<Integer>[] graph = new List[8];
        graph[0] = Arrays.asList(1, 3, 6, 7);
        graph[1] = Arrays.asList(0, 2);
        graph[2] = Arrays.asList(1);
        graph[3] = Arrays.asList(0, 4);
        graph[4] = Arrays.asList(3);
        graph[5] = Arrays.asList();
        graph[6] = Arrays.asList(0, 1);
        graph[7] = Arrays.asList(0);
        List<Integer> expected = Arrays.asList(0, 7, 6, 1, 2, 3, 4, 5);

        //test
        List<Integer> bfs = this.graphTraversal.dfsIterative(graph);

        //verify
        assertEquals(bfs, expected);
    }

}