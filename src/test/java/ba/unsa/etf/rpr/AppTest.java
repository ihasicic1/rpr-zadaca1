package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void mainTest() {
        String str = new String(" ");
        ExpressionEvaluator exp = new ExpressionEvaluator();
        assertThrows(RuntimeException.class, ()-> exp.evaluate(str), "Empty string");

    }
}