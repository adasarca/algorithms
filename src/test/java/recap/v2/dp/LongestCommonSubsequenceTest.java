package recap.v2.dp;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/*
 * Created by AdelaSarca
 * Date: 2/27/2020
 */
public class LongestCommonSubsequenceTest {

    private LongestCommonSubsequence longestCommonSubsequence;

    @BeforeMethod
    public void setup() {
        this.longestCommonSubsequence = new LongestCommonSubsequence();
    }

    @Test
    public void testCommon0() {
        //test
        String common = this.longestCommonSubsequence.common("helloworld", "children");

        //verify
        assertEquals(common, "hlr");
    }

    @Test
    public void testCommon1() {
        //test
        String common = this.longestCommonSubsequence.common("abcdgh", "aedfhr");

        //verify
        assertEquals(common, "adh");
    }
}