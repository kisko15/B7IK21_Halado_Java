package hu.meiit.haladojava.calculator;

import java.util.Scanner;

public class App 
{
    public static void main(String[] args ) {
        CalculatorService calculateService = new CalculatorService();
        Scanner calculator = new Scanner(System.in);
        System.out.println("Input:");
        double calculate = calculateService.calculate(calculator.nextLine());
        if (calculateService.getCheckException() > 0) {
            System.out.println("Output:");
            System.out.println("-");
        } else {
            System.out.println("Output:");
            System.out.println(calculate);
        }



    }
}
