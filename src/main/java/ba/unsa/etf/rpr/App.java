package ba.unsa.etf.rpr;

public class App {
    public static void main( String[] args ) {
        String s = args[0];
        ExpressionEvaluator expression = new ExpressionEvaluator();
        if(s.isEmpty()) System.out.println("Empty string");
        else {
            System.out.println(Math.round(expression.evaluate(s)*100.) / 100.);
        }
    }
}
