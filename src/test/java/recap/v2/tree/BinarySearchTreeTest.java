package recap.v2.tree;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

public class BinarySearchTreeTest {

    @Test
    public void testAdd() throws Exception {
        //setup
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        List<Integer> expected = Arrays.asList(5, 10, 12, 20, 22, 23, 25, 28, 30, 36, 38, 39, 40, 48);

        //test
        tree.add(25);
        tree.add(20);
        tree.add(36);
        tree.add(10);
        tree.add(22);
        tree.add(5);
        tree.add(40);
        tree.add(38);
        tree.add(39);
        tree.add(23);
        tree.add(30);
        tree.add(48);
        tree.add(12);
        tree.add(28);
        tree.add(28);

        //verify
        assertEquals(tree.asList(), expected);
    }

    @Test
    public void testContains0() throws Exception {
        //setup
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.add(25);
        tree.add(20);
        tree.add(36);
        tree.add(10);
        tree.add(22);
        tree.add(5);
        tree.add(40);
        tree.add(38);
        tree.add(39);
        tree.add(23);
        tree.add(30);
        tree.add(48);
        tree.add(12);
        tree.add(28);

        //test
        boolean found = tree.contains(25);

        //verify
        assertTrue(found);
    }

    @Test
    public void testContains1() throws Exception {
        //setup
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.add(25);
        tree.add(20);
        tree.add(36);
        tree.add(10);
        tree.add(22);
        tree.add(5);
        tree.add(40);
        tree.add(38);
        tree.add(39);
        tree.add(23);
        tree.add(30);
        tree.add(48);
        tree.add(12);
        tree.add(28);

        //test
        boolean found = tree.contains(39);

        //verify
        assertTrue(found);
    }

    @Test
    public void testContains2() throws Exception {
        //setup
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.add(25);
        tree.add(20);
        tree.add(36);
        tree.add(10);
        tree.add(22);
        tree.add(5);
        tree.add(40);
        tree.add(38);
        tree.add(39);
        tree.add(23);
        tree.add(30);
        tree.add(48);
        tree.add(12);
        tree.add(28);

        //test
        boolean found = tree.contains(40);

        //verify
        assertTrue(found);
    }

    @Test
    public void testContains3() throws Exception {
        //setup
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.add(25);
        tree.add(20);
        tree.add(36);
        tree.add(10);
        tree.add(22);
        tree.add(5);
        tree.add(40);
        tree.add(38);
        tree.add(39);
        tree.add(23);
        tree.add(30);
        tree.add(48);
        tree.add(12);
        tree.add(28);

        //test
        boolean found = tree.contains(100);

        //verify
        assertFalse(found);
    }

    @Test
    public void testRemove_NoChildren() throws Exception {
        //setup
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.add(25);
        tree.add(20);
        tree.add(36);
        tree.add(10);
        tree.add(22);
        tree.add(5);
        tree.add(40);
        tree.add(38);
        tree.add(39);
        tree.add(23);
        tree.add(30);
        tree.add(48);
        tree.add(12);
        tree.add(28);
        List<Integer> expected = Arrays.asList(5, 10, 12, 20, 22, 23, 25, 30, 36, 38, 39, 40, 48);

        //test
        tree.remove(28);

        //verify
        assertEquals(tree.asList(), expected);
    }

    @Test
    public void testRemove_OneChild() throws Exception {
        //setup
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.add(25);
        tree.add(20);
        tree.add(36);
        tree.add(10);
        tree.add(22);
        tree.add(5);
        tree.add(40);
        tree.add(38);
        tree.add(39);
        tree.add(23);
        tree.add(30);
        tree.add(48);
        tree.add(12);
        tree.add(28);
        List<Integer> expected = Arrays.asList(5, 10, 12, 20, 23, 25, 28, 30, 36, 38, 39, 40, 48);

        //test
        tree.remove(22);

        //verify
        assertEquals(tree.asList(), expected);
    }

    @Test
    public void testRemove_TwoChildren_RightChildSuccessor() throws Exception {
        //setup
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.add(25);
        tree.add(20);
        tree.add(36);
        tree.add(10);
        tree.add(22);
        tree.add(5);
        tree.add(40);
        tree.add(38);
        tree.add(39);
        tree.add(23);
        tree.add(30);
        tree.add(48);
        tree.add(12);
        tree.add(28);
        List<Integer> expected = Arrays.asList(5, 10, 12, 22, 23, 25, 28, 30, 36, 38, 39, 40, 48);

        //test
        tree.remove(20);

        //verify
        assertEquals(tree.asList(), expected);
    }

    @Test
    public void testRemove_TwoChildren_RightLeftChildSuccessor() throws Exception {
        //setup
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.add(25);
        tree.add(20);
        tree.add(36);
        tree.add(10);
        tree.add(22);
        tree.add(5);
        tree.add(40);
        tree.add(38);
        tree.add(39);
        tree.add(23);
        tree.add(30);
        tree.add(48);
        tree.add(12);
        tree.add(28);
        List<Integer> expected = Arrays.asList(5, 10, 12, 20, 22, 23, 25, 28, 30, 38, 39, 40, 48);

        //test
        tree.remove(36);

        //verify
        assertEquals(tree.asList(), expected);
    }

    @Test
    public void testRemove_Root() throws Exception {
        //setup
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.add(25);
        tree.add(20);
        tree.add(36);
        tree.add(10);
        tree.add(22);
        tree.add(5);
        tree.add(40);
        tree.add(38);
        tree.add(39);
        tree.add(23);
        tree.add(30);
        tree.add(48);
        tree.add(12);
        tree.add(28);
        List<Integer> expected = Arrays.asList(5, 10, 12, 20, 22, 23, 28, 30, 36, 38, 39, 40, 48);

        //test
        tree.remove(25);

        //verify
        assertEquals(tree.asList(), expected);
    }

}