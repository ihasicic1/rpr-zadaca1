package ba.unsa.etf.rpr;

import java.util.Stack;

public class ExpressionEvaluator {
    private Stack<String> operators = new Stack<String>();
    private Stack<Double> operands = new Stack<Double>();

    private boolean checkSqrt(String s, int i){
        return s.substring(i,i+3).equals("sqrt");
    }

    private int numberLength(String s, int i){
        int counter = 0;
        for(int j = i; j < s.length(); j++){
            if((s.charAt(i) >= '0' && s.charAt(i) <= '9') || s.charAt(i)=='.'){
                counter++;
            }else break;
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
            else if(s.charAt(i) == 's' && checkSqrt(s, i)) {operators.push("sqrt");i+=3;}
            else if(s.charAt(i) == ')') {
                String op = operators.pop();
                double v = operands.pop();
                if(op.equals("+")) v = operands.pop() + v;
                else if(op.equals("-") ) v = operands.pop() - v;
                else if(op.equals("*")) v = operands.pop() * v;
                else if(op.equals("/")) v = operands.pop() / v;
                else if(op.equals("sqrt")) v = Math.sqrt(v);
                operands.push(v);
            }else operands.push(Double.parseDouble(s.substring(i,numberLength(s,i))));
        }
        return operands.pop();
    }

}
