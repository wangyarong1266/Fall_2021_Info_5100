package edu.northeastern.hw5;

public class Question1 {

    public static void main(String[] args) {
        Car sportsCar = new SportsCar(new BasicCar());
        sportsCar.assemble();

        System.out.println();

        Car sportsLuxuryCar = new SportsCar(new LuxuryCar(new BasicCar()));
        sportsLuxuryCar.assemble();
    }
}

interface Car {
    void assemble();
}

class BasicCar implements Car {

    @Override
    public void assemble() {
        System.out.print("Basic Car.");
    }
}

abstract class CarDecorator implements Car {
    protected Car car;

    CarDecorator(Car car) {
        this.car = car;
    }
}

class LuxuryCar extends CarDecorator{
    LuxuryCar(Car car) {
        super(car);
    }

    @Override
    public void assemble() {
        car.assemble();
        System.out.print(" Adding features of Luxury Car.");
    }
}

class SportsCar extends CarDecorator {
    SportsCar(Car car) {
        super(car);
    }

    @Override
    public void assemble() {
        car.assemble();
        System.out.println(" Adding features of Sports Car.");
    }
}
