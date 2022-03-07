package hu.meiit.haladojava.calculator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Stack;

public class CalculatorService {

    private char[] arr;
    private int index = 0;
    private int checkException = 0;
    private final char[] OPERATORS = {'+','-','*','/'};

    public double calculate(String s) {
        arr = s.toCharArray();
        return stackUp(stackInput());
    }

    private Stack<Double> stackInput() {
        Stack<Double> stack = new Stack<>();
        char operator = '+';

        while (index < arr.length) {
            if (arr[index] != ' ') {
                if (Character.isDigit(arr[index])) {
                    StringBuilder buildNum = new StringBuilder();
                    while (index < arr.length && Character.isDigit(arr[index])) {
                        buildNum.append(arr[index++]);
                    }
                    index--;

                    double curNum = Double.parseDouble(buildNum.toString());
                        insertElement(stack, curNum, operator);
                    } else if (!checkValidOperators(arr[index])){
                    try {
                        checkException++;
                        throw new NoSuchOperatorException();
                    } catch (NoSuchOperatorException e) {

                    }
                } else {
                        operator = arr[index];
                    }
            }
            index++;
        }
        return stack;
    }

    public double stackUp(Stack<Double> stack) {
        double total = 0;
        while (!stack.isEmpty()) {
            total += stack.pop();
        }
        BigDecimal bigDecimal = new BigDecimal(total);
        bigDecimal = bigDecimal.setScale(1, RoundingMode.HALF_UP);
        return bigDecimal.doubleValue();
    }

    private void insertElement(Stack<Double> stack, double curNum, char operator) {
        try {
            if (operator == '-') {
                curNum *= -1;
            } else if (operator == '*') {
                curNum *= stack.pop();
            } else if (operator == '/') {
                if (curNum != 0) {
                    curNum = stack.pop() / curNum;
                } else {
                    checkException++;
                    throw new NullPointerException();
                }
            }
            stack.push(curNum);
        } catch (NullPointerException e) {

        }
    }

    public boolean checkValidOperators(char character) {
        for (char characterItem : OPERATORS) {
            if (characterItem == character) {
                return true;
            }
        }
        return false;
    }

    public int getCheckException() {
        return checkException;
    }
}
