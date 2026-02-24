package model;

/**
 * Класс представляющий координаты точки
 */

public final class Coordinates {
    private double x;
    private int y; //Максимальное значение поля: 71

    public Coordinates(double x, int y) {
        if (y > 71) throw new IllegalArgumentException("Y > 71");

        this.x = x;
        this.y = y;
    }

    public Coordinates() {}

    public void setX(double x) {
        this.x = x;
    }

    public void setY(int y) {
        if (y > 71) throw new IllegalArgumentException("Y > 71");
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "\n      X = " + x
                + ";\n      Y = " + y;
    }
}