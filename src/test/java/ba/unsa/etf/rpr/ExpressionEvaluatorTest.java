package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ExpressionEvaluatorTest extends ExpressionEvaluator{

    @Test
    void numberLengthTest() {
        String s = "132.29";
        assertEquals(6 , numberLength(s,0));
    }

    @Test
    void evaluateTest() {
        String s = " ( 1.5 + 2.7 ) ";
        ExpressionEvaluator expression = new ExpressionEvaluator();
        assertEquals(4.2, expression.evaluate(s));
    }

    @Test
    void evaluateDivisionWithZeroTest(){
        String s = " ( 5 / 0 ) ";
        ExpressionEvaluator expression = new ExpressionEvaluator();
        assertThrows(RuntimeException.class, () -> expression.evaluate(s), "Division by zero not possible");
    }

    @Test
    void evaluateDivisionTest(){
        String s = "( 17 / 4 )";
        ExpressionEvaluator expression = new ExpressionEvaluator();
        assertEquals(4.25, expression.evaluate(s));
    }

    @Test
    void evaluateAdditionTest(){
        String s = "( 14.235 + 54.549 )";
        ExpressionEvaluator expression = new ExpressionEvaluator();
        assertEquals(68.784, Math.round(expression.evaluate(s)*1000.)/1000.);
    }

    @Test
    void evaluateSubtractionTest(){
        String s = ("( 4.25 - 2.69 )");
        ExpressionEvaluator e = new ExpressionEvaluator();
        assertEquals(1.56, e.evaluate(s));
    }

    @Test
    void evaluateMultiplicationTest(){
        String s = ("( 4.25 * 2.69 )");
        ExpressionEvaluator e = new ExpressionEvaluator();
        assertEquals(11.4325, e.evaluate(s));
    }

    @Test
    void inputNotValidTest(){
        String s = ("(5+ 2 )");
        ExpressionEvaluator e = new ExpressionEvaluator();
        assertThrows(RuntimeException.class, () -> e.evaluate(s), "Input not valid");
    }

}