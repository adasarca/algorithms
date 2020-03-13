package interview.google2020;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class UniqueSubstringTest {

    private UniqueSubstring uniqueSubstring;

    @BeforeMethod
    public void setup() {
        this.uniqueSubstring = new UniqueSubstring();
    }

    @Test
    public void testSubstring0() throws Exception {
        //setup
        String s = "abcdefabcdefg";

        //test
        String substring = this.uniqueSubstring.substring(s);

        //verify
        assertEquals(substring, "abcdefg");
    }

    @Test
    public void testSubstring1() throws Exception {
        //setup
        String s = "abXcdeXfgh";

        //test
        String substring = this.uniqueSubstring.substring(s);

        //verify
        assertEquals(substring, "cdeXfgh");
    }

}