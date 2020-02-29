package recap.v2.math;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ExpressionEvaluationTest {

    private ExpressionEvaluation expressionEvaluation;

    @BeforeMethod
    public void setup() {
        this.expressionEvaluation = new ExpressionEvaluation();
    }

    @Test
    public void testEvaluate() throws Exception {
        //setup
        String expression = "2 + 3 * 10 - (70 + 2) / 8 * 3";

        //test
        long result = this.expressionEvaluation.evaluate(expression);

        //verify
        assertEquals(result, 5);
    }

}