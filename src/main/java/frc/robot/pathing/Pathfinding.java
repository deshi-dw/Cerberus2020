package frc.robot.pathing;

public class Pathfinding {
    private byte[][] nodes;
    private int width = 10;
    private int height = 10;

    public Pathfinding(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
}