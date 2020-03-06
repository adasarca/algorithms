package recap.v2.graph.paths;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import recap.v2.BellmanFordPaths;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

public class BellmanFordTest {
    
    private BellmanFord bellmanFord;
    
    @BeforeMethod
    public void setup() {
        this.bellmanFord = new BellmanFord();
    }
    
    @Test
    public void testDistances() throws Exception {
        //setup
        List<Node>[] graph = new List[5];
        graph[0] = Arrays.asList(
                new Node(1, -1),
                new Node(2, 4)
        );
        graph[1] = Arrays.asList(
                new Node(2, 3),
                new Node(3, 2),
                new Node(4, 2)
        );
        graph[2] = Arrays.asList();
        graph[3] = Arrays.asList(
                new Node(1, 1),
                new Node(2, 5)
        );
        graph[4] = Arrays.asList(
                new Node(3, -3)
        );
        int[] expected = new int[]{0, -1, 2, -2, 1};

        //test
        int[] distance = this.bellmanFord.distances(graph, 0);

        //verify
        assertEquals(distance, expected);
    }

    @Test
    public void testPaths_NegativeCycle() {
        //setup
        List<Node>[] graph = new List[4];
        graph[0] = Arrays.asList(
                new Node(1, -1)
        );
        graph[1] = Arrays.asList(
                new Node(2, -2)
        );
        graph[2] = Arrays.asList(
                new Node(0, 1),
                new Node(3, 2)
        );
        graph[3] = Arrays.asList();

        //test
        int[] distance = this.bellmanFord.distances(graph, 0);

        //verify
        assertNull(distance);
    }

}