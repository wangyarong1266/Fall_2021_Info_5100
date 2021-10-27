package edu.northeastern.midterm;

public class Question2 {

    public static void main(String[] args) {
        Printer printer = Printer.getInstance();
        printer.print();
    }
}

class Printer {

    private static final Printer printer = new Printer();

    private Printer() {
    }

    public static Printer getInstance() {
        return printer;
    }

    public void print() {
        System.out.println("The printer " + this.hashCode() + " is working");
    }
}