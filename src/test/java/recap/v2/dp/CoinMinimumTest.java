package recap.v2.dp;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.testng.Assert.*;

/*
 * Created by AdelaSarca
 * Date: 2/28/2020
 */
public class CoinMinimumTest {

    private CoinMinimum coinMinimum;

    @BeforeTest
    public void setup() {
        this.coinMinimum = new CoinMinimum();
    }

    @Test
    public void testMin() {
        //setup
        int amount = 5;
        Set<Integer> coins = new HashSet<>(Arrays.asList(1, 2, 5));

        //test
        int combinations = this.coinMinimum.min(amount, coins);

        //verify
        assertEquals(combinations, 1);
    }
}