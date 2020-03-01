package recap.v2.graph.paths;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

public class FloydWarshallTest {

    private FloydWarshall floydWarshall;

    @BeforeMethod
    public void setup() {
        this.floydWarshall = new FloydWarshall();
    }

    @Test
    public void testDistances() throws Exception {
        //setup
        List<Node>[] graph = new List[6];
        graph[0] = Arrays.asList(
                new Node(1, 9),
                new Node(2, 5));
        graph[1] = Arrays.asList(
                new Node(0, 9),
                new Node(2, 3),
                new Node(3, 5),
                new Node(4, 7));
        graph[2] = Arrays.asList(
                new Node(0, 5),
                new Node(1, 3),
                new Node(3, 10));
        graph[3] = Arrays.asList(
                new Node(1, 5),
                new Node(2, 10),
                new Node(4, 1),
                new Node(5, 4));
        graph[4] = Arrays.asList(
                new Node(1, 7),
                new Node(3, 1),
                new Node(5, 2));
        graph[5] = Arrays.asList(
                new Node(3, 4),
                new Node(4, 2));

        int[][] expected = new int[][]{
                {0, 8, 5, 13, 14, 16},
                {8, 0, 3, 5, 6, 8},
                {5, 3, 0, 8, 9, 11},
                {13, 5, 8, 0, 1, 3},
                {14, 6, 9, 1, 0, 2},
                {16, 8, 11, 3, 2, 0}
        };

        //test
        int[][] d = this.floydWarshall.distances(graph);

        //verify
        assertNotNull(d);
        assertEquals(d.length, expected.length);
        for (int i = 0; i < expected.length; i++)
            assertEquals(d[i], expected[i]);
    }

}