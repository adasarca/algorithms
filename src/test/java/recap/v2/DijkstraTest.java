package recap.v2;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

/*
 * Created by AdelaSarca
 * Date: 1/30/2020
 */
public class DijkstraTest {

    private Dijkstra dijkstra;

    @BeforeMethod
    public void setup() {
        this.dijkstra = new Dijkstra();
    }

    @Test
    public void testDistance() {
        //setup
        List<Dijkstra.Node>[] graph = new List[9];
        graph[0] = Arrays.asList(
                new Dijkstra.Node(1, 4),
                new Dijkstra.Node(7, 8)
        );
        graph[1] = Arrays.asList(
                new Dijkstra.Node(0, 4),
                new Dijkstra.Node(2, 8),
                new Dijkstra.Node(7, 11)
        );
        graph[2] = Arrays.asList(
                new Dijkstra.Node(1, 8),
                new Dijkstra.Node(3, 7),
                new Dijkstra.Node(8, 2)
        );
        graph[3] = Arrays.asList(
                new Dijkstra.Node(2, 7),
                new Dijkstra.Node(4, 9),
                new Dijkstra.Node(5, 14)
        );
        graph[4] = Arrays.asList(
                new Dijkstra.Node(3, 9),
                new Dijkstra.Node(5, 10)
        );
        graph[5] = Arrays.asList(
                new Dijkstra.Node(2, 4),
                new Dijkstra.Node(3, 14),
                new Dijkstra.Node(4, 10),
                new Dijkstra.Node(6, 2)
        );
        graph[6] = Arrays.asList(
                new Dijkstra.Node(5, 2),
                new Dijkstra.Node(7, 1),
                new Dijkstra.Node(8, 6)
        );
        graph[7] = Arrays.asList(
                new Dijkstra.Node(0, 8),
                new Dijkstra.Node(1, 11),
                new Dijkstra.Node(6, 1),
                new Dijkstra.Node(8, 7)
        );
        graph[8] = Arrays.asList(
                new Dijkstra.Node(2, 2),
                new Dijkstra.Node(6, 6),
                new Dijkstra.Node(7, 7)
        );
        int[] expected = new int[] {0, 4, 12, 19, 21, 11, 9, 8, 14};

        //test
        int[] distance = this.dijkstra.distance(graph, 0, 4);

        //verify
        assertEquals(distance, expected);
    }
}