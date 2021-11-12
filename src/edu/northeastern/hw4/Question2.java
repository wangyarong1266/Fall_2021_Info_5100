package edu.northeastern.hw4;

public class Question2 {
}

class TrafficLight {

    private int curGreenRoad;

    public TrafficLight(int curGreenRoad) {
        this.curGreenRoad = curGreenRoad;
    }

    public void carArrived(int carId, int roadId, int direction, Runnable turnGreen, Runnable crossCar) {
        synchronized (this) {
            if (curGreenRoad != roadId) {
                turnGreen.run();
                curGreenRoad = roadId;
            }
            crossCar.run();
        }
    }
}
