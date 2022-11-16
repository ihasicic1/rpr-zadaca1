package ba.unsa.etf.rpr;

import java.util.Scanner;
import java.util.Stack;

public class App {
    public static void main( String[] args )
    {
       /* String str = new String();
        for(int i = 0; i < args.length; i++ ) {
            str = args[i] + " ";
        }*/

        System.out.println( "Input expression: " );
        String s = new String();
        Scanner in = new Scanner(System.in);
        s = in.nextLine();
        if(s.isEmpty()) throw new RuntimeException("Empty string");

        ExpressionEvaluator expression = new ExpressionEvaluator();
        System.out.println(expression.evaluate(s));
    }
}
