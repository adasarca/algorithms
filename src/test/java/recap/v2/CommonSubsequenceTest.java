package recap.v2;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/*
 * Created by AdelaSarca
 * Date: 1/20/2020
 */
public class CommonSubsequenceTest {

    private CommonSubsequence commonSubsequence;

    @BeforeMethod
    public void setup() {
        this.commonSubsequence = new CommonSubsequence();
    }

    @Test
    public void testLongest() {
        //setup
        String s1 = "helloworld";
        String s2 = "children";
        String expected = "hld";

        //test
        String res = this.commonSubsequence.longest(s1, s2);

        //verify
        assertEquals(res, expected);
    }
}