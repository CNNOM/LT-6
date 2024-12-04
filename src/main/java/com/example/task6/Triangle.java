package com.example.task6;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Triangle extends Shape {
    private double side;

    public Triangle(double side, Color color) {
        super(side, color);
        this.side = side;
        this.type = "Треугольник";
    }

    @Override
    public void draw(GraphicsContext gc, double x, double y) {
        this.x = x;
        this.y = y;
        gc.setFill(color);
        double height = side * Math.sqrt(3) / 2;
        double[] xPoints = {x, x + side / 2, x + side};
        double[] yPoints = {y + height, y, y + height};
        gc.fillPolygon(xPoints, yPoints, 3);
    }

    @Override
    public String toString() {
        return "Triangle";
    }
}