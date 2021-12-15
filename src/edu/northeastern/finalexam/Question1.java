package edu.northeastern.finalexam;

public class Question1 {

    public static void main(String[] args) {
        int[][] room = {{0, 0, 0, 1},
                        {1, 0, -1, 0},
                        {1, 0, 0, -1},
                        {0, 0, 1, -1}};
        iRobot robot = new Roomba(room);
        robot.move();
        robot.turnLeft();
        robot.move();
        robot.move();
        robot.turnRight();
        robot.move();
        robot.clean();
        System.out.println(robot);
    }
}

enum Direction {
    UP,
    DOWN,
    LEFT,
    RIGHT
}

interface iRobot {
    boolean move();

    void turnLeft();

    void turnRight();

    void clean();
}

class Roomba implements iRobot {

    private Direction direction = Direction.DOWN;
    private final int[][] room;
    private int locationX = 0;
    private int locationY = 0;

    private final int[] dx = {-1, 1, 0, 0};
    private final int[] dy = {0, 0, -1, 1};

    Roomba(int[][] room) {
        this.room = room;
    }

    @Override
    public boolean move() {
        int nextX = locationX + dx[direction.ordinal()];
        int nextY = locationY + dy[direction.ordinal()];

        if (!isValid(nextX, nextY)) {
            return false;
        }

        locationX = nextX;
        locationY = nextY;
        return true;
    }

    @Override
    public void turnLeft() {
        switch (direction) {
            case UP -> direction = Direction.LEFT;
            case DOWN -> direction = Direction.RIGHT;
            case LEFT -> direction = Direction.DOWN;
            case RIGHT -> direction = Direction.UP;
        }
    }

    @Override
    public void turnRight() {
        switch (direction) {
            case UP -> direction = Direction.RIGHT;
            case DOWN -> direction = Direction.LEFT;
            case LEFT -> direction = Direction.UP;
            case RIGHT -> direction = Direction.DOWN;
        }
    }

    @Override
    public void clean() {
        room[locationX][locationY] = 1;
    }

    private boolean isValid(int x, int y) {
        return 0 <= x && x < room.length && 0 <= y && y < room[0].length && room[x][y] != -1;
    }

    @Override
    public String toString() {
        return String.format("The current location is (%d, %d)", locationX, locationY);
    }
}