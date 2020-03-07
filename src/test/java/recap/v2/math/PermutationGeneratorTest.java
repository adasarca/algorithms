package recap.v2.math;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class PermutationGeneratorTest {

    private PermutationGenerator permutationGenerator;

    @BeforeMethod
    public void setup() {
        this.permutationGenerator = new PermutationGenerator();
    }

    @Test
    public void testGenerate0() throws Exception {
        List<Integer[]> permutations = this.permutationGenerator.generate(4);

        assertNotNull(permutations);
        assertEquals(permutations.size(), 24);
    }

    @Test
    public void testGenerate1() throws Exception {
        List<Integer[]> permutations = this.permutationGenerator.generate(5);

        assertNotNull(permutations);
        assertEquals(permutations.size(), 120);
    }

}