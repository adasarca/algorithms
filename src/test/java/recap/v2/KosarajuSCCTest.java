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
public class KosarajuSCCTest {

    private KosarajuSCC kosarajuSCC;

    @BeforeMethod
    public void setup() {
        this.kosarajuSCC = new KosarajuSCC();
    }

    @Test
    public void testScc() {
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
        List<List<Integer>> components = this.kosarajuSCC.scc(graph);

        //verify
        assertEquals(components, expected);
    }
}