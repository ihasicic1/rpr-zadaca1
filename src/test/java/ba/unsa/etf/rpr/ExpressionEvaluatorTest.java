package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class ExpressionEvaluatorTest {

    @Test
    void numberLengthTest() {
        String s = "( 132.95 + 2.7 )";
        Stack<Double> brojevi = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(');
            else if(s.charAt(i) == ' ');
            else if(s.charAt(i) == '+');
            else if(s.charAt(i) == ')');
            else{
                int shift = ExpressionEvaluator.numberLength(s,i);
                String rez = s.substring(i,i + shift);
                brojevi.push(Double.parseDouble(rez));
                i += shift;
            }
        }
        assertEquals("132.95 2.7", ("132.95 2.7"));
    }

    @Test
    void evaluateTest() {
        String s = "( 1.5 + 2.7 )";
        ExpressionEvaluator expression = new ExpressionEvaluator();
        System.out.println(expression.evaluate(s));
        assertEquals(4.2, 4.2);
    }

}