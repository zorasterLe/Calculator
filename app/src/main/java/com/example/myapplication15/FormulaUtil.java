package com.example.myapplication15;
import java.math.BigDecimal;
import java.util.Stack;

public class FormulaUtil {
    private int scale;
    private Stack<BigDecimal> numberStack = null;
    private Stack<Character> symbolStack = null;

    public FormulaUtil(int scale) {
        super();
        this.scale = scale;
    }

    public FormulaUtil() {
        this(32);
    }

    public String caculate(String numStr) {
        numStr = removeStrSpace(numStr);
        if (numStr.length() > 1
                && !"=".equals(numStr.charAt(numStr.length() - 1) + "")) {
            numStr += "=";
        }
        if (!isStandard(numStr)) {
            System.err.println("错误：算术表达式有误！");
            return null;
        }
        if (numberStack == null) {
            numberStack = new Stack<BigDecimal>();
        }
        numberStack.clear();
        if (symbolStack == null) {
            symbolStack = new Stack<Character>();
        }
        symbolStack.clear();
        StringBuffer temp = new StringBuffer();
        for (int i = 0; i < numStr.length(); i++) {
            char ch = numStr.charAt(i);
            if (isNumber(ch)) {
                temp.append(ch);
            } else {
                String tempStr = temp.toString();
                if (!tempStr.isEmpty()) {
                    BigDecimal num = new BigDecimal(tempStr);
                    numberStack.push(num);
                    temp = new StringBuffer();
                }
                while (!comparePri(ch) && !symbolStack.empty()) {
                    BigDecimal b = numberStack.pop();
                    BigDecimal a = numberStack.pop();
                    switch ((char) symbolStack.pop()) {
                        case '+':
                            numberStack.push(a.add(b));
                            break;
                        case '-':
                            numberStack.push(a.subtract(b));
                            break;
                        case '*':
                            numberStack.push(a.multiply(b));
                            break;
                        case '/':
                            try {
                                numberStack.push(a.divide(b));
                            } catch (java.lang.ArithmeticException e) {
                                numberStack.push(a.divide(b, this.scale,
                                        BigDecimal.ROUND_HALF_EVEN));
                            }
                            break;
                        default:
                            break;
                    }
                }
                if (ch != '=') {
                    symbolStack.push(new Character(ch));
                    if (ch == ')') {
                        symbolStack.pop();
                        symbolStack.pop();
                    }
                }
            }
        }

        return numberStack.pop().toString();
    }

    private String removeStrSpace(String str) {
        return str != null ? str.replaceAll(" ", "") : "";
    }

    private boolean isStandard(String numStr) {
        if (numStr == null || numStr.isEmpty())
            return false;
        Stack<Character> stack = new Stack<Character>();
        boolean b = false;
        for (int i = 0; i < numStr.length(); i++) {
            char n = numStr.charAt(i);
            if (!(isNumber(n) || "(".equals(n + "") || ")".equals(n + "")
                    || "+".equals(n + "") || "-".equals(n + "")
                    || "*".equals(n + "") || "/".equals(n + "") || "=".equals(n
                    + ""))) {
                return false;
            }
            if ("(".equals(n + "")) {
                stack.push(n);
            }
            if (")".equals(n + "")) {
                if (stack.isEmpty() || !"(".equals((char) stack.pop() + "")) // 括号是否匹配
                    return false;
            }
            if ("=".equals(n + "")) {
                if (b)
                    return false;
                b = true;
            }
        }
        if (!stack.isEmpty())
            return false;
        if (!("=".equals(numStr.charAt(numStr.length() - 1) + "")))
            return false;
        return true;
    }

    private boolean isNumber(char num) {
        if ((num >= '0' && num <= '9') || num == '.')
            return true;
        return false;
    }

    private boolean comparePri(char symbol) {
        if (symbolStack.empty()) {
            return true;
        }
        char top = (char) symbolStack.peek(); // 查看堆栈顶部的对象，注意不是出栈
        if (top == '(') {
            return true;
        }
        switch (symbol) {
            case '(':
                return true;
            case '*': {
                if (top == '+' || top == '-')
                    return true;
                else
                    return false;
            }
            case '/': {
                if (top == '+' || top == '-')
                    return true;
                else
                    return false;
            }
            case '+':
                return false;
            case '-':
                return false;
            case ')': // 优先级最低
                return false;
            case '=': // 结束符
                return false;
            default:
                break;
        }
        return true;
    }
}
