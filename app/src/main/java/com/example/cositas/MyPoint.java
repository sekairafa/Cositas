package com.example.cositas;

public class MyPoint{
    private double x;
    private double y;

    public MyPoint() {
        this.set(0, 0);
    }

    public MyPoint(double x, double y) {
        this.set(x, y);
    }

    public MyPoint(MyPoint point) {
        this.set(point.getX(), point.getY());
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public MyPoint set(int index, double val) {
        if (index == 0) {
            this.setX(val);
        }
        else if (index == 1) {
            this.setY(val);
        }
        return this;
    }

    public MyPoint set(double x, double y) {
        return this.setX(x).setY(y);
    }

    public MyPoint set(MyPoint point) {
        return this.setX(point.getX()).setY(point.getY());
    }

    public MyPoint setX(double x) {
        this.x = x;
        return this;
    }

    public MyPoint setY(double y) {
        this.y = y;
        return this;
    }

    public MyPoint swap() {
        double temp = this.getX();
        this.setX(this.getY());
        return this.setY(temp);
    }

    public static void swapAll(MyPoint[] points) {
        int length = points.length;

        for (int i = 0; i < length; i++) {
            points[i].swap();
        }
    }
}
