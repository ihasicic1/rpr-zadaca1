package ba.unsa.etf.rpr;

import java.util.Scanner;
import java.util.Stack;

public class App {
    public static void main( String[] args ) {
//        String s = args[0];
//        ExpressionEvaluator expression = new ExpressionEvaluator();
//        if(s.isEmpty()) System.out.println("Empty string");
//        else System.out.println(expression.evaluate(s));
        //String s = new String("( ( ( 1.5 + 2.7 ) * ( 1 + 2 ) ) - 2.6 )" );
        //String s = new String("( 4.25 * ( 2 + 2 ) )");
//        String s = new String("( 14.235 + 54.549 )");
        String s = new String("2.12345678912345");
        System.out.println(ExpressionEvaluator.numberLength(s, 0));
        System.out.println(s.substring(0, ExpressionEvaluator.numberLength(s, 0)));
        //ExpressionEvaluator rez = new ExpressionEvaluator();
        //System.out.println(rez.evaluate(s));
    }
}
