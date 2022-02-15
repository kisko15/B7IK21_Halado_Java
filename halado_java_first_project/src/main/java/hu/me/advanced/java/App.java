package hu.me.advanced.java;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    private static Integer getInt(String str, int order) {
        Integer rv = null;

        try {
            rv = Integer.valueOf(str);

        } catch (NumberFormatException nex) {
            System.out.println("Az " + order + ". bemeneti paraméter nem jó. A bemenő adatnak számnak kell lennie. Pl.: 0,1" );
        }
        return rv;
    }





    public static void main( String[] args )
    {

        Repezentation repezentation = new Repezentation(args);
        Operands operands = repezentation.getOperands();

        Integer a = getInt(operands.getA(), 1);
        Integer b = getInt(operands.getB(), 2);

        if (a != null && b != null) {
            repezentation.printResult(new Service().calculate(a, b));
        }

    }
}
