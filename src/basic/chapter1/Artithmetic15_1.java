package basic.chapter1;

import java.util.Stack;

public class Artithmetic15_1 {

    /**
     * 计算器
     *
     * @param args
     */
    public static void main(String[] args) {
        Artithmetic15_1 artithmetic15_1 = new Artithmetic15_1();
        Integer calulate = artithmetic15_1.calulate("3+4*((4*10-10/2)+5)#");
        System.out.println("calulate:" + calulate);

    }

    private Stack<Integer> numberStack = new Stack<>();
    private Stack<Character> oprStack = new Stack<>();


    public Integer calulate(String data) {
        if (data.isEmpty()) {
            return -1;
        }
        clear();
        int from = 0, to = 0;
        char[] chars = data.toCharArray();

        while (from < data.length() && to < data.length()) {
            boolean number = isNumber(chars[from]);
            //数字可能是多个，它是按照字符拆分的
            do {
                to++;
            } while (to < data.length() && number && isNumber(chars[to]));

            if (number) {
                //添加数字
                numberStack.push(Integer.parseInt(new String(chars, from, to - from)));
            } else {
                //添加操作符
                addOpr(chars[from]);

            }
            from = to; //移位赋值
        }
        return numberStack.pop();
    }

    private void addOpr(char aChar) {
        while (!oprStack.empty() && isNeedCal(aChar)) {
            calc();
        }
        if (aChar == ')') {
            oprStack.pop();
        } else if (aChar != '#') {
            oprStack.push(aChar);
        }

    }

    private boolean isNeedCal(Character c) {
        Character lastElement = oprStack.lastElement();
        if (c == '(' || lastElement == '(') return false;
        if (c == '*' || c == '/') return lastElement == '*' || lastElement == '/';
        if (c == '#' || c == ')' || c == '+' || c == '-') return true;
        throw new IllegalArgumentException();

    }

    private void calc() {
        int second = numberStack.pop();
        int first = numberStack.pop();
        char opr = oprStack.pop();
        switch (opr) {
            case '+':
                numberStack.push(first + second);
                break;
            case '-':
                numberStack.push(first - second);
                break;
            case '*':
                numberStack.push(first * second);
                break;
            case '/':
                numberStack.push(first / second);
                break;
        }
    }

    private void clear() {
        numberStack.clear();
        oprStack.clear();
    }

    //判断是否是数字
    private boolean isNumber(char str) {
        return str <= '9' && str >= '0';
    }
}
