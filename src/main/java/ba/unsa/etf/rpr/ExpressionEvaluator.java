package ba.unsa.etf.rpr;

import java.util.Stack;

/**
 * Dijkstra algorithm implementation class
 */
public class ExpressionEvaluator {
    private final Stack<String> operators = new Stack<>();
    private final Stack<Double> operands = new Stack<>();

    /**
     * method for checking if input string has operator sqrt
     * @param s
     * @param i
     * @return s.startsWith("sqrt", i);
     */
    private boolean checkSqrt(String s, int i){
        return s.startsWith("sqrt", i);
    }

    /**
     * method that calculates length of an operand
     * @param s
     * @param i
     * @return counter
     */
    protected static int numberLength(String s, int i){
        int counter = 0;
        for(int j = i; j < s.length(); j++){
            if(s.charAt(j) == ' ') break;  /* skips spaces, counts digits and dots */
            counter++;
        }
        return counter;
    }

    /**
     * method for evaluating the expression
     * @param s
     * @return operands.pop()
     */
    public Double evaluate(String s){
        for(int i = 0; i < s.length(); i++){

            if(s.charAt(i) == '(' && s.charAt(i+1) == ' ');
            else if(s.charAt(i) == '+' && s.charAt(i+1) == ' ') operators.push("+");
            else if(s.charAt(i) == '-' && s.charAt(i+1) == ' ') operators.push("-");
            else if(s.charAt(i) == '*' && s.charAt(i+1) == ' ') operators.push("*");
            else if(s.charAt(i) == '/' && s.charAt(i+1) == ' ') operators.push("/");
            else if(s.charAt(i) == 's' && checkSqrt(s,i)  && s.charAt(i+4) == ' ') {operators.push("sqrt"); i = i + 4;} /* if "s", check if it equals "sqrt", increase i by four */
            else if(s.charAt(i) == ')' && s.charAt(i-1) == ' ') {
                String op = operators.pop();
                double v = operands.pop();
                if(op.equals("+")) v = operands.pop() + v;
                else if(op.equals("-") ) v = operands.pop() - v;
                else if(op.equals("*")) v = operands.pop() * v;
                else if(op.equals("/")) {
                    if(v == 0) throw new RuntimeException("Division by zero not possible");  //if denominator equals zero
                    v = operands.pop() / v;
                }
                else if(op.equals("sqrt")) v = Math.sqrt(v);
                operands.push(v);
            }
            else if(s.charAt(i) == ' ');
            else {
                int shift = numberLength(s,i);
                try{
                    operands.push(Double.parseDouble(s.substring(i, i + shift))); //token not parenthesis or operator, push value
                    i = i + shift;
                }catch(NumberFormatException e){
                    throw new RuntimeException("Input not valid!");
                }
            }
        }
        if(operators.size() > 0 || operands.size() != 1) throw new RuntimeException("Input not valid");
        return operands.pop();
    }

}
