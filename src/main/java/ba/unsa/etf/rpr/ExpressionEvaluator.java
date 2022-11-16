package ba.unsa.etf.rpr;

import java.util.Stack;

public class ExpressionEvaluator {
    private Stack<String> operators = new Stack<String>();
    private Stack<Double> operands = new Stack<Double>();

    private boolean checkSqrt(String s, int i){
        return s.substring(i, i+4).equals("sqrt");
    }

    public static int numberLength(String s, int i){
        int counter = 0;
        for(int j = i; j < s.length(); j++){
            if(s.charAt(j) == ' ') break;
            counter++;

        }
        return counter;
    }

    public Double evaluate(String s){
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(');
            else if(s.charAt(i) == '+') operators.push("+");
            else if(s.charAt(i) == '-') operators.push("-");
            else if(s.charAt(i) == '*') operators.push("*");
            else if(s.charAt(i) == '/') operators.push("/");
            else if(s.charAt(i) == 's' && checkSqrt(s, i)) {operators.push("sqrt"); i = i + 4;}
            else if(s.charAt(i) == ')') {
                String op = operators.pop();
                double v = operands.pop();
                if(op.equals("+")) v = operands.pop() + v;
                else if(op.equals("-") ) v = operands.pop() - v;
                else if(op.equals("*")) v = operands.pop() * v;
                else if(op.equals("/")) {
                    if(v == 0) throw new RuntimeException("Division by zero not possible");
                    v = operands.pop() / v;
                }
                else if(op.equals("sqrt")) v = Math.sqrt(v);
                operands.push(v);
            }else if(s.charAt(i) == ' ');
            else {
                int pomak = numberLength(s,i);
                operands.push(Double.parseDouble(s.substring(i, i + pomak)));
                i = i + pomak;
            }
        }
        return operands.pop();
    }

}
