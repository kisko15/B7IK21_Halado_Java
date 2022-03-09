package hu.meiit.haladojava.calculator;

import java.util.Scanner;

public class App 
{
    private static String getExpressionFromStandardInput() {
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine();
        scanner.close();
        return expression;
    }

    public static void main(String[] args ) {

        try {
            CalculatorService calculateService = new CalculatorService();
            double calculate = calculateService.calculate(getExpressionFromStandardInput());
            System.out.println(calculate);
        } catch (NullPointerException | NoSuchOperatorException exp) {
            System.out.println("-");
        }

    }
}
