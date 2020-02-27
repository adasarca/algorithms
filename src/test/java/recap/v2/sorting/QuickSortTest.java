package recap.v2.sorting;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/*
 * Created by AdelaSarca
 * Date: 2/27/2020
 */
public class QuickSortTest {

    private QuickSort quickSort;

    @BeforeMethod
    public void setup() {
        this.quickSort = new QuickSort();
    }

    @Test
    public void testSort() {
        //setup
        int[] a = new int[]{-6, 8, 10, 155, 264, -85, -83, 21, 19, -25, -6};
        int[] expected = new int[]{-85, -83, -25, -6, -6, 8, 10, 19, 21, 155, 264};

        //test
        this.quickSort.sort(a);

        //verify
        assertEquals(a, expected);
    }
}