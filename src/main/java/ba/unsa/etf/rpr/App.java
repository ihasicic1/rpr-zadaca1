package ba.unsa.etf.rpr;

import java.util.Scanner;

public class App
{
    public static void main( String[] args )
    {
        System.out.println( "Unesite izraz: " );
        String s = new String();
        Scanner ulaz = new Scanner(System.in);
        s = ulaz.nextLine();
        ExpressionEvaluator izraz = new ExpressionEvaluator();
        System.out.println(izraz.evaluate(s));
    }
}
