package edu.northeastern.hw2;

public class Sum {

    public int add(int x, int y) {
        return x + y;
    }

    public int add(int x, int y, int z) {
        return x + y + z;
    }

    public double add(int x, double y) {
        return x + y;
    }

    public double add(double x, int y) {
        return x + y;
    }

    public double add(double x, double y) {
        return x + y;
    }

    public static void main(String[] args) {
        Sum sum = new Sum();
        System.out.println(sum.add(2, 3));
        System.out.println(sum.add(4, 9, 12));
        System.out.println(sum.add(4, 5.0));
        System.out.println(sum.add(15.5, 5));
        System.out.println(sum.add(1.0, 6.4));
    }
}
