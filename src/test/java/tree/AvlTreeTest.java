package tree;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

public class AvlTreeTest {

    private AvlTree avlTree;

    @BeforeMethod
    public void setup() {
        this.avlTree = new AvlTree();
    }

    @Test
    public void testInsert() throws Exception {
        //setup
        List<Integer> expected = Arrays.asList(5, 10, 12, 20, 22, 23, 25, 28, 30, 36, 38, 39, 40, 48);

        //test
        this.avlTree.insert(5);
        this.avlTree.insert(10);
        this.avlTree.insert(12);
        this.avlTree.insert(20);
        this.avlTree.insert(22);
        this.avlTree.insert(23);
        this.avlTree.insert(25);
        this.avlTree.insert(48);
        this.avlTree.insert(40);
        this.avlTree.insert(39);
        this.avlTree.insert(38);
        this.avlTree.insert(36);
        this.avlTree.insert(30);
        this.avlTree.insert(28);
        List<Integer> list = this.avlTree.asList();

        //verify
        assertEquals(list, expected);
    }

    @Test
    public void testContains() throws Exception {
    }

    @Test
    public void testDelete() throws Exception {
        //setup
        List<Integer> expected = Arrays.asList(25, 28, 30, 36, 38, 39, 40, 48);

        //test
        this.avlTree.insert(5);
        this.avlTree.insert(10);
        this.avlTree.insert(12);
        this.avlTree.insert(20);
        this.avlTree.insert(22);
        this.avlTree.insert(23);
        this.avlTree.insert(25);
        this.avlTree.insert(48);
        this.avlTree.insert(40);
        this.avlTree.insert(39);
        this.avlTree.insert(38);
        this.avlTree.insert(36);
        this.avlTree.insert(30);
        this.avlTree.insert(28);

        this.avlTree.delete(5);
        this.avlTree.delete(10);
        this.avlTree.delete(12);
        this.avlTree.delete(20);
        this.avlTree.delete(22);
        this.avlTree.delete(23);
        List<Integer> list = this.avlTree.asList();

        //verify
        assertEquals(list, expected);
    }

}