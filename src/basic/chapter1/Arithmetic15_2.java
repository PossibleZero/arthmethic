package basic.chapter1;

import java.util.Scanner;
import java.util.Stack;

public class Arithmetic15_2 {

    /**
     * 计算器的算法
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Double> values = new Stack<>();
        Stack<String> oper = new Stack<>();
        while (scanner.hasNext()) {
            String s = scanner.next();
            if (s.equals("$")) break;
            if (s.equals("(")) ;
            else if (s.equals("+")) oper.push(s);
            else if (s.equals("-")) oper.push(s);
            else if (s.equals("*")) oper.push(s);
            else if (s.equals("/")) oper.push(s);
            else if (s.equals("sqrt")) oper.push(s);
            else if (s.equals(")")) {
                String op = oper.pop();
                double v = values.pop();
                if (op.equals("+")) v = values.pop() + v;
                if (op.equals("-")) v = values.pop() - v;
                if (op.equals("*")) v = values.pop() * v;
                if (op.equals("/")) v = values.pop() / v;
                if (op.equals("sqrt")) v = Math.sqrt(v);
                values.push(v);
            } else {
                values.push(Double.parseDouble(s));
            }

        }

        System.out.println(values.pop());
    }

}
