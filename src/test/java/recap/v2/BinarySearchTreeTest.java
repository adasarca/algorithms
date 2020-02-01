package recap.v2;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

public class BinarySearchTreeTest {

    private BinarySearchTree binarySearchTree;

    @BeforeMethod
    public void setup() {
        this.binarySearchTree = new BinarySearchTree();
    }

    @Test
    public void testFind() throws Exception {
        //setup
        BinarySearchTree.Node node = this.binarySearchTree.insert(null, 25);
        node = this.binarySearchTree.insert(node, 20);
        node = this.binarySearchTree.insert(node, 36);
        node = this.binarySearchTree.insert(node, 10);
        node = this.binarySearchTree.insert(node, 22);
        node = this.binarySearchTree.insert(node, 5);
        node = this.binarySearchTree.insert(node, 40);
        node = this.binarySearchTree.insert(node, 38);
        node = this.binarySearchTree.insert(node, 39);
        node = this.binarySearchTree.insert(node, 23);
        node = this.binarySearchTree.insert(node, 30);
        node = this.binarySearchTree.insert(node, 48);
        node = this.binarySearchTree.insert(node, 12);
        node = this.binarySearchTree.insert(node, 28);

        //test
        BinarySearchTree.Node found = this.binarySearchTree.find(node, 25);

        //verify
        assertEquals(found, node);
    }

    @Test
    public void testFind2() throws Exception {
        //setup
        BinarySearchTree.Node node = this.binarySearchTree.insert(null, 25);
        node = this.binarySearchTree.insert(node, 20);
        node = this.binarySearchTree.insert(node, 36);
        node = this.binarySearchTree.insert(node, 10);
        node = this.binarySearchTree.insert(node, 22);
        node = this.binarySearchTree.insert(node, 5);
        node = this.binarySearchTree.insert(node, 40);
        node = this.binarySearchTree.insert(node, 38);
        node = this.binarySearchTree.insert(node, 39);
        node = this.binarySearchTree.insert(node, 23);
        node = this.binarySearchTree.insert(node, 30);
        node = this.binarySearchTree.insert(node, 48);
        node = this.binarySearchTree.insert(node, 12);
        node = this.binarySearchTree.insert(node, 28);

        //test
        BinarySearchTree.Node found = this.binarySearchTree.find(node, 39);

        //verify
        assertEquals(found, new BinarySearchTree.Node(39));
    }

    @Test
    public void testFind3() throws Exception {
        //setup
        BinarySearchTree.Node node = this.binarySearchTree.insert(null, 25);
        node = this.binarySearchTree.insert(node, 20);
        node = this.binarySearchTree.insert(node, 36);
        node = this.binarySearchTree.insert(node, 10);
        node = this.binarySearchTree.insert(node, 22);
        node = this.binarySearchTree.insert(node, 5);
        node = this.binarySearchTree.insert(node, 40);
        node = this.binarySearchTree.insert(node, 38);
        node = this.binarySearchTree.insert(node, 39);
        node = this.binarySearchTree.insert(node, 23);
        node = this.binarySearchTree.insert(node, 30);
        node = this.binarySearchTree.insert(node, 48);
        node = this.binarySearchTree.insert(node, 12);
        node = this.binarySearchTree.insert(node, 28);

        BinarySearchTree.Node expected = new BinarySearchTree.Node(40);
        expected.left = new BinarySearchTree.Node(38);
        expected.left.right = new BinarySearchTree.Node(39);
        expected.right = new BinarySearchTree.Node(48);

        //test
        BinarySearchTree.Node found = this.binarySearchTree.find(node, 40);

        //verify
        assertEquals(found, expected);
    }

    @Test
    public void testInsert() throws Exception {
        //setup
        List<Integer> expected = Arrays.asList(5, 10, 12, 20, 22, 23, 25, 28, 30, 36, 38, 39, 40, 48);

        //test
        BinarySearchTree.Node node = this.binarySearchTree.insert(null, 25);
        node = this.binarySearchTree.insert(node, 20);
        node = this.binarySearchTree.insert(node, 36);
        node = this.binarySearchTree.insert(node, 10);
        node = this.binarySearchTree.insert(node, 22);
        node = this.binarySearchTree.insert(node, 5);
        node = this.binarySearchTree.insert(node, 40);
        node = this.binarySearchTree.insert(node, 38);
        node = this.binarySearchTree.insert(node, 39);
        node = this.binarySearchTree.insert(node, 23);
        node = this.binarySearchTree.insert(node, 30);
        node = this.binarySearchTree.insert(node, 48);
        node = this.binarySearchTree.insert(node, 12);
        node = this.binarySearchTree.insert(node, 28);
        List<Integer> list = this.binarySearchTree.getList(node);

        //verify
        assertEquals(list, expected);
    }

    @Test
    public void testDelete_OneChild() throws Exception {
        //setup
        BinarySearchTree.Node node = this.binarySearchTree.insert(null, 25);
        node = this.binarySearchTree.insert(node, 20);
        node = this.binarySearchTree.insert(node, 36);
        node = this.binarySearchTree.insert(node, 10);
        node = this.binarySearchTree.insert(node, 22);
        node = this.binarySearchTree.insert(node, 5);
        node = this.binarySearchTree.insert(node, 40);
        node = this.binarySearchTree.insert(node, 38);
        node = this.binarySearchTree.insert(node, 39);
        node = this.binarySearchTree.insert(node, 23);
        node = this.binarySearchTree.insert(node, 30);
        node = this.binarySearchTree.insert(node, 48);
        node = this.binarySearchTree.insert(node, 12);
        node = this.binarySearchTree.insert(node, 28);
        List<Integer> expected = Arrays.asList(5, 10, 12, 20, 23, 25, 28, 30, 36, 38, 39, 40, 48);

        //test
        BinarySearchTree.Node result = this.binarySearchTree.delete(node, 22);
        List<Integer> list = this.binarySearchTree.getList(result);

        //verify
        assertEquals(list, expected);
    }

    @Test
    public void testDelete_TwoChildren_RightChildSuccessor() throws Exception {
        //setup
        BinarySearchTree.Node node = this.binarySearchTree.insert(null, 25);
        node = this.binarySearchTree.insert(node, 20);
        node = this.binarySearchTree.insert(node, 36);
        node = this.binarySearchTree.insert(node, 10);
        node = this.binarySearchTree.insert(node, 22);
        node = this.binarySearchTree.insert(node, 5);
        node = this.binarySearchTree.insert(node, 40);
        node = this.binarySearchTree.insert(node, 38);
        node = this.binarySearchTree.insert(node, 39);
        node = this.binarySearchTree.insert(node, 23);
        node = this.binarySearchTree.insert(node, 30);
        node = this.binarySearchTree.insert(node, 48);
        node = this.binarySearchTree.insert(node, 12);
        node = this.binarySearchTree.insert(node, 28);
        List<Integer> expected = Arrays.asList(5, 10, 12, 22, 23, 25, 28, 30, 36, 38, 39, 40, 48);

        //test
        BinarySearchTree.Node result = this.binarySearchTree.delete(node, 20);
        List<Integer> list = this.binarySearchTree.getList(result);

        //verify
        assertEquals(list, expected);
    }

    @Test
    public void testDelete_TwoChildren_RightLeftChildSuccessor() throws Exception {
        //setup
        BinarySearchTree.Node node = this.binarySearchTree.insert(null, 25);
        node = this.binarySearchTree.insert(node, 20);
        node = this.binarySearchTree.insert(node, 36);
        node = this.binarySearchTree.insert(node, 10);
        node = this.binarySearchTree.insert(node, 22);
        node = this.binarySearchTree.insert(node, 5);
        node = this.binarySearchTree.insert(node, 40);
        node = this.binarySearchTree.insert(node, 38);
        node = this.binarySearchTree.insert(node, 39);
        node = this.binarySearchTree.insert(node, 23);
        node = this.binarySearchTree.insert(node, 30);
        node = this.binarySearchTree.insert(node, 48);
        node = this.binarySearchTree.insert(node, 12);
        node = this.binarySearchTree.insert(node, 28);
        List<Integer> expected = Arrays.asList(5, 10, 12, 20, 22, 23, 25, 28, 30, 38, 39, 40, 48);

        //test
        BinarySearchTree.Node result = this.binarySearchTree.delete(node, 36);
        List<Integer> list = this.binarySearchTree.getList(result);

        //verify
        assertEquals(list, expected);
    }

    @Test
    public void testDelete_Root() throws Exception {
        //setup
        BinarySearchTree.Node node = this.binarySearchTree.insert(null, 25);
        node = this.binarySearchTree.insert(node, 20);
        node = this.binarySearchTree.insert(node, 36);
        node = this.binarySearchTree.insert(node, 10);
        node = this.binarySearchTree.insert(node, 22);
        node = this.binarySearchTree.insert(node, 5);
        node = this.binarySearchTree.insert(node, 40);
        node = this.binarySearchTree.insert(node, 38);
        node = this.binarySearchTree.insert(node, 39);
        node = this.binarySearchTree.insert(node, 23);
        node = this.binarySearchTree.insert(node, 30);
        node = this.binarySearchTree.insert(node, 48);
        node = this.binarySearchTree.insert(node, 12);
        node = this.binarySearchTree.insert(node, 28);
        List<Integer> expected = Arrays.asList(5, 10, 12, 20, 22, 23, 28, 30, 36, 38, 39, 40, 48);

        //test
        BinarySearchTree.Node result = this.binarySearchTree.delete(node, 25);
        List<Integer> list = this.binarySearchTree.getList(result);

        //verify
        assertEquals(list, expected);
    }

    @Test
    public void testDelete_NoChildren() throws Exception {
        //setup
        BinarySearchTree.Node node = this.binarySearchTree.insert(null, 25);
        node = this.binarySearchTree.insert(node, 20);
        node = this.binarySearchTree.insert(node, 36);
        node = this.binarySearchTree.insert(node, 10);
        node = this.binarySearchTree.insert(node, 22);
        node = this.binarySearchTree.insert(node, 5);
        node = this.binarySearchTree.insert(node, 40);
        node = this.binarySearchTree.insert(node, 38);
        node = this.binarySearchTree.insert(node, 39);
        node = this.binarySearchTree.insert(node, 23);
        node = this.binarySearchTree.insert(node, 30);
        node = this.binarySearchTree.insert(node, 48);
        node = this.binarySearchTree.insert(node, 12);
        node = this.binarySearchTree.insert(node, 28);
        List<Integer> expected = Arrays.asList(5, 10, 12, 20, 22, 23, 25, 30, 36, 38, 39, 40, 48);

        //test
        BinarySearchTree.Node result = this.binarySearchTree.delete(node, 28);
        List<Integer> list = this.binarySearchTree.getList(result);

        //verify
        assertEquals(list, expected);
    }

}