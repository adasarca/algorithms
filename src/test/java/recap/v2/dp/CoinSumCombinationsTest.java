package recap.v2.dp;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.testng.Assert.*;

/*
 * Created by AdelaSarca
 * Date: 2/28/2020
 */
public class CoinSumCombinationsTest {

    private CoinSumCombinations coinSumCombinations;

    @BeforeMethod
    public void setup() {
        this.coinSumCombinations = new CoinSumCombinations();
    }

    @Test
    public void testCombinations() {
        //setup
        int amount = 5;
        Set<Integer> coins = new HashSet<>(Arrays.asList(1, 2, 5));

        //test
        int combinations = this.coinSumCombinations.combinations(amount, coins);

        //verify
        assertEquals(combinations, 4);
    }
}