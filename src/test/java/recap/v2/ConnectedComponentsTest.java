package recap.v2;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.testng.Assert.*;

/*
 * Created by AdelaSarca
 * Date: 1/30/2020
 */
public class ConnectedComponentsTest {

    private ConnectedComponents connectedComponents;

    @BeforeMethod
    public void setup() {
        this.connectedComponents = new ConnectedComponents();
    }

    @Test
    public void testComponents() {
        //setup
        List<Integer>[] graph = new List[14];
        graph[0] = Arrays.asList(1, 9);
        graph[1] = Arrays.asList(0, 10);
        graph[2] = Arrays.asList(6);
        graph[3] = Arrays.asList(6);
        graph[4] = Arrays.asList(5, 7);
        graph[5] = Arrays.asList(4, 7);
        graph[6] = Arrays.asList(3, 8);
        graph[7] = Arrays.asList(4, 5);
        graph[8] = Arrays.asList(6);
        graph[9] = Arrays.asList(0);
        graph[10] = Arrays.asList(1, 11);
        graph[11] = Arrays.asList(10);
        graph[12] = Arrays.asList();
        graph[13] = Arrays.asList();
        List<List<Integer>> expected = new LinkedList<>();
        expected.add(Arrays.asList(0, 1, 10, 11, 9));
        expected.add(Arrays.asList(2, 6, 3, 8));
        expected.add(Arrays.asList(4, 5, 7));
        expected.add(Arrays.asList(12));
        expected.add(Arrays.asList(13));

        //test
        List<List<Integer>> components = this.connectedComponents.components(graph);

        //verify
        assertEquals(components, expected);
    }
}