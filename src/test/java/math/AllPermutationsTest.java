package math;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/*
 * Created by AdelaSarca
 * Date: 3/6/2020
 */
public class AllPermutationsTest {

    private AllPermutations allPermutations;

    @BeforeMethod
    public void setup() {
        this.allPermutations = new AllPermutations();
    }

    @Test
    public void testGenerate() {
        //test
        this.allPermutations.generate(4);
    }
}