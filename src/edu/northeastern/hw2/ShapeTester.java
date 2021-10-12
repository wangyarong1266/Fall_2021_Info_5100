package edu.northeastern.hw2;

class Shape {

    private String name;
    private String color;
    private int perimeter;
    private int area;

    Shape() {}

    Shape(String name, String color) {
        this.name = name;
        this.color = color;
    }

    Shape(String name, String color, int perimeter, int area) {
        this.name = name;
        this.color = color;
        this.perimeter = perimeter;
        this.area = area;
    }

    public String printShape() {
        return String.format("The %s has a %s color", name, color);
    }

    public int getPerimeter() {
        return perimeter;
    }

    public void setPerimeter(int perimeter) {
        this.perimeter = perimeter;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }
}

class Rectangle extends Shape {
    private int width;
    private int height;

    Rectangle(int side) {
        this.width = side;
        this.height = side;
    }

    Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    Rectangle(String name, String color, int width, int height) {
        super(name, color);
        this.width = width;
        this.height = height;
    }

    @Override
    public int getArea() {
        return width * height;
    }

    @Override
    public int getPerimeter() {
        return 2 * (width + height);
    }
}

class Square extends Shape {
    private int side;

    Square(int side) {
        this.side = side;
    }

    Square(String name, String color, int side) {
        super(name, color);
        this.side = side;
    }

    @Override
    public int getArea() {
        return side * side;
    }

    @Override
    public int getPerimeter() {
        return side * 4;
    }
}

public class ShapeTester {

    public static void main(String[] args) {
        Shape shape1 = new Shape("Shape1", "pink");
        System.out.println("shape1");
        System.out.println(shape1.printShape());

        Shape shape2 = new Shape("Shape2", "orange", 20, 30);
        System.out.println("shape2");
        System.out.println("area: " + shape2.getArea() + " perimeter: " + shape2.getPerimeter());
        System.out.println(shape2.printShape());

        Rectangle rectangle1 = new Rectangle(2);
        System.out.println("rectangle1");
        System.out.println("area: " + rectangle1.getArea() + " perimeter: " + rectangle1.getPerimeter());

        Rectangle rectangle2 = new Rectangle("Rectangle", "Purple", 4, 7);
        System.out.println("rectangle2");
        System.out.println("area: " + rectangle2.getArea() + " perimeter: " + rectangle2.getPerimeter());
        System.out.println(rectangle2.printShape());

        Square square1 = new Square(3);
        System.out.println("square1");
        System.out.println("area: " + square1.getArea() + " perimeter: " + square1.getPerimeter());

        Square square2 = new Square("Square", "black", 7);
        System.out.println("square2");
        System.out.println("area: " + square2.getArea() + " perimeter: " + square2.getPerimeter());
        System.out.println(square2.printShape());
    }
}
