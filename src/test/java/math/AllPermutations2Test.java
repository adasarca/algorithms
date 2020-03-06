package math;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/*
 * Created by AdelaSarca
 * Date: 3/6/2020
 */
public class AllPermutations2Test {

    private AllPermutations2 allPermutations2;

    @BeforeMethod
    public void setup() {
        this.allPermutations2 = new AllPermutations2();
    }

    @Test
    public void testGenerate() {
        this.allPermutations2.generate(4);
    }
}