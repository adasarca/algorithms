package recap.v2;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

/*
 * Created by AdelaSarca
 * Date: 1/31/2020
 */
public class BellmanFordPathsTest {

    private BellmanFordPaths bellmanFordPaths;

    @BeforeMethod
    public void setup() {
        this.bellmanFordPaths = new BellmanFordPaths();
    }

    @Test
    public void testPaths() {
        //setup
        List<BellmanFordPaths.Node>[] graph = new List[5];
        graph[0] = Arrays.asList(
                new BellmanFordPaths.Node(1, -1),
                new BellmanFordPaths.Node(2, 4)
        );
        graph[1] = Arrays.asList(
                new BellmanFordPaths.Node(2, 3),
                new BellmanFordPaths.Node(3, 2),
                new BellmanFordPaths.Node(4, 2)
        );
        graph[2] = Arrays.asList();
        graph[3] = Arrays.asList(
                new BellmanFordPaths.Node(1, 1),
                new BellmanFordPaths.Node(2, 5)
        );
        graph[4] = Arrays.asList(
                new BellmanFordPaths.Node(3, -3)
        );
        int[] expected = new int[]{0, -1, 2, -2, 1};

        //test
        int[] distance = this.bellmanFordPaths.paths(graph, 0);

        //verify
        assertEquals(distance, expected);
    }

    @Test
    public void testPaths_NegativeCycle() {
        //setup
        List<BellmanFordPaths.Node>[] graph = new List[4];
        graph[0] = Arrays.asList(
                new BellmanFordPaths.Node(1, -1)
        );
        graph[1] = Arrays.asList(
                new BellmanFordPaths.Node(2, -2)
        );
        graph[2] = Arrays.asList(
                new BellmanFordPaths.Node(0, 1),
                new BellmanFordPaths.Node(3, 2)
        );
        graph[3] = Arrays.asList();

        //test
        int[] distance = this.bellmanFordPaths.paths(graph, 0);

        //verify
        assertNull(distance);
    }
}