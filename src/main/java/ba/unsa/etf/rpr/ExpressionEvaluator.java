package ba.unsa.etf.rpr;

import java.util.Stack;

public class ExpressionEvaluator {       //class that implements Dijkstra algorithm
    private final Stack<String> operators = new Stack<>();
    private final Stack<Double> operands = new Stack<>();

    private boolean checkSqrt(String s, int i){     //method for checking if input string has operator sqrt
        return s.substring(i, i+4).equals("sqrt");
    }

    protected static int numberLength(String s, int i){     //method that calculates length of an operand, a dot '.' is also considered +1
        int counter = 0;
        for(int j = i; j < s.length(); j++){
            if(s.charAt(j) == ' ') break;                //skips spaces, counts digits and dots
            counter++;
        }
        return counter;
    }

    public Double evaluate(String s){  //method for evaluating the expression
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(');
            else if(s.charAt(i) == '+') operators.push("+");
            else if(s.charAt(i) == '-') operators.push("-");
            else if(s.charAt(i) == '*') operators.push("*");
            else if(s.charAt(i) == '/') operators.push("/");
            else if(s.charAt(i) == 's' && checkSqrt(s, i)) {operators.push("sqrt"); i = i + 4;} //if "s", check if it equals "sqrt", increase i by four
            else if(s.charAt(i) == ')') {
                String op = operators.pop();     //pop, evaluate and push result if token is ")"
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
            }   else if(s.charAt(i) == ' ');
                else {
                    int shift = numberLength(s,i);
                    try{
                        operands.push(Double.parseDouble(s.substring(i, i + shift)));    //token not operator or paranthesis, push double value
                        i = i + shift;
                    }catch(NumberFormatException e){
                        throw new RuntimeException("Input not valid!");
                    }

                }
        }
        return operands.pop();
    }

}
