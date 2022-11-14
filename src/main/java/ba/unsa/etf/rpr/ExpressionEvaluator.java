package ba.unsa.etf.rpr;

import java.util.Stack;

public class ExpressionEvaluator {
    private Stack<String> operators = new Stack<String>();
    private Stack<Double> operands = new Stack<Double>();

    public Double evaluate(String s){
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(');
            else if(s.charAt(i) == '+') operators.push("+");
            else if(s.charAt(i) == '-') operators.push("-");
            else if(s.charAt(i) == '*') operators.push("*");
            else if(s.charAt(i) == '/') operators.push("/");
            else if(s.charAt(i) == 's' && provjeraSqrt(s, i)) {operators.push("sqrt");i+=3;}
            else if(s.charAt(i) == ')') {
                String op = operators.pop();
                double v = operands.pop();
                if(op.equals("+")) v = operands.pop() + v;
                else if(op.equals("-") ) v = operands.pop() - v;
                else if(op.equals("*")) v = operands.pop() * v;
                else if(op.equals("/")) v = operands.pop() / v;
                else if(op.equals("sqrt")) v = Math.sqrt(v);
                operands.push(v);
            }else operands.push(Double.parseDouble(s.substring(i,duzinaBroja(s,i))));
        }
        return operands.pop();
    }

}
