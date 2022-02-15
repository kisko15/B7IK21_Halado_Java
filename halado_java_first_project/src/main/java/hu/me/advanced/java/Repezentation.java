package hu.me.advanced.java;

public class Repezentation {

    private String[] args;

    public Repezentation(String[] args) {
        this.args = args;
    }

    public void printResult(int result) {
        //kiírása
        System.out.println("Result: " + result);
    }

    public Operands getOperands() {
       return new Operands().setA(args[0]).setB(args[1]);
    }
}
