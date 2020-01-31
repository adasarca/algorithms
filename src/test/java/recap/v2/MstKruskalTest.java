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
public class MstKruskalTest {

    private MstKruskal mstKruskal;

    @BeforeMethod
    public void setup() {
        this.mstKruskal = new MstKruskal();
    }

    @Test
    public void testMst() {
        //setup
        List<MstKruskal.Node>[] graph = new List[8];
        graph[0] = Arrays.asList(
                new MstKruskal.Node(1, 3),
                new MstKruskal.Node(6, 2),
                new MstKruskal.Node(7, 5)
        );
        graph[1] = Arrays.asList(
                new MstKruskal.Node(0, 3),
                new MstKruskal.Node(2, 13),
                new MstKruskal.Node(7, 2)
        );
        graph[2] = Arrays.asList(
                new MstKruskal.Node(1, 13),
                new MstKruskal.Node(3, 3),
                new MstKruskal.Node(4, 2),
                new MstKruskal.Node(7, 6)
        );
        graph[3] = Arrays.asList(
                new MstKruskal.Node(2, 3),
                new MstKruskal.Node(4, 6)
        );
        graph[4] = Arrays.asList(
                new MstKruskal.Node(2, 2),
                new MstKruskal.Node(3, 6),
                new MstKruskal.Node(5, 6),
                new MstKruskal.Node(7, 3)
        );
        graph[5] = Arrays.asList(
                new MstKruskal.Node(4, 6),
                new MstKruskal.Node(6, 5),
                new MstKruskal.Node(7, 4)
        );
        graph[6] = Arrays.asList(
                new MstKruskal.Node(0, 2),
                new MstKruskal.Node(5, 5),
                new MstKruskal.Node(7, 2)
        );
        graph[7] = Arrays.asList(
                new MstKruskal.Node(0, 5),
                new MstKruskal.Node(1, 2),
                new MstKruskal.Node(2, 6),
                new MstKruskal.Node(4, 3),
                new MstKruskal.Node(5, 4),
                new MstKruskal.Node(6, 2)
        );

        //test
        int mst = this.mstKruskal.mst(graph);

        //verify
        assertEquals(mst, 18);
    }
}