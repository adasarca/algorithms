package recap.v2.dp;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class PalindromeCountTest {

    private PalindromeCount palindromeCount;

    @BeforeMethod
    public void setup() {
        this.palindromeCount = new PalindromeCount();
    }

    @Test
    public void testCount() throws Exception {
        //test
        int count = this.palindromeCount.count("abaddaba");

        //verify
        assertEquals(count, 6);
    }

}